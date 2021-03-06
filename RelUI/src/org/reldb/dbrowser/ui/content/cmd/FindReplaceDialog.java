package org.reldb.dbrowser.ui.content.cmd;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.LineBackgroundEvent;
import org.eclipse.swt.custom.LineBackgroundListener;
import org.eclipse.swt.custom.StyledText;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.RowLayout;

public class FindReplaceDialog extends Dialog {

	private Shell shell;

	private Label lblFind;
	private Text textFind;

	private Label lblReplace;
	private Text textReplace;

	private Composite compositeDirectionScope;
	private Group grpDirection;
	private Button btnRadioForward;
	private Button btnRadioBackward;

	private Composite compositeButtons;
	private Group grpScope;
	private Button btnRadioAll;
	private Button btnRadioSelected;

	private Composite compositeOptions;
	private Group grpOptions;
	private Button btnCheckCaseSensitive;
	private Button btnCheckWholeWord;
	private Button btnCheckRegexp;
	private Button btnCheckWrapsearch;
	private Button btnCheckIncremental;

	private Button btnFind;
	private Button btnReplaceFind;
	private Button btnReplace;
	private Button btnReplaceAll;

	private Composite compositeStatusAndClose;
	private Label lblStatus;

	private StyledText text;

	private Vector<Match> matches = null;
	private int lastFindIndex = -1;
	private Point lastReplacementRange = null;

	private int preservedCaretOffset;

	private Point originalTextSelection;
	private static final Color originalSelectionHighlightColor = SWTResourceManager.getColor(255, 200, 200);

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public FindReplaceDialog(Shell parent, StyledText text) {
		super(parent, SWT.DIALOG_TRIM | SWT.RESIZE);
		this.text = text;
		setText("Find/Replace");
		text.addExtendedModifyListener(textModifyListener);
		text.addSelectionListener(textSelectionListener);
		text.addFocusListener(textFocusListener);
		text.addLineBackgroundListener(textLineBackgroundListener);
		originalTextSelection = text.getSelectionRange();
	}

	private void refreshText() {
		int topIndex = text.getTopIndex(); // this guarantees a redraw, where text.redraw() does not
		text.setTopIndex(text.getLineCount());
		text.setTopIndex(topIndex);
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		textFind.setText(text.getSelectionText());
		textFind.setSelection(0, text.getCharCount());
		refreshText();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return null;
	}

	private Timer textModifyTimer = new Timer();

	private ExtendedModifyListener textModifyListener = new ExtendedModifyListener() {
		@Override
		public void modifyText(ExtendedModifyEvent event) {
			clearAll();
			lastFindIndex = -1;
			originalTextSelection = new Point(0, 0);
			textModifyTimer.cancel();
			textModifyTimer = new Timer();
			textModifyTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					textModifyTimer.cancel();
					Display.getDefault().syncExec(() -> {
						clearAll();
						doFind();
					});
				}
			}, 250);
		}
	};

	private SelectionListener textSelectionListener = new SelectionAdapter() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			boolean selected = e.y - e.x > 0;
			btnReplace.setEnabled(selected);
			btnReplaceFind.setEnabled(selected);
		}
	};

	private FocusListener textFocusListener = new FocusListener() {
		@Override
		public void focusLost(FocusEvent e) {
			preservedCaretOffset = getCaretOffset();
		}

		@Override
		public void focusGained(FocusEvent e) {
			lastFindIndex = -1;
		}
	};

	private Point getOriginalSelectionLines() {
		int startLine = text.getLineAtOffset(originalTextSelection.x);
		int endLine = text.getLineAtOffset(originalTextSelection.x + originalTextSelection.y);
		return new Point(startLine, endLine);
	}

	private Point getOriginalSelectionLineOffsets() {
		Point originalSelectionLines = getOriginalSelectionLines();
		int lineCount = text.getLineCount();
		int start = text.getOffsetAtLine(originalSelectionLines.x);
		int end;
		if (originalSelectionLines.y >= lineCount - 1)
			end = text.getCharCount();
		else
			end = text.getOffsetAtLine(originalSelectionLines.y + 1) - 1;
		return new Point(start, end);
	}

	private boolean isOverlappingOriginalSelectionLineOffsetRange(int start, int length) {
		int end = start + length;
		Point originalSelectionLineRange = getOriginalSelectionLineOffsets();
		return (start <= originalSelectionLineRange.y) && (end >= originalSelectionLineRange.x);
	}

	private LineBackgroundListener textLineBackgroundListener = new LineBackgroundListener() {
		@Override
		public void lineGetBackground(LineBackgroundEvent event) {
			if (!btnRadioSelected.getSelection())
				return;
			if (isOverlappingOriginalSelectionLineOffsetRange(event.lineOffset, event.lineText.length()))
				event.lineBackground = originalSelectionHighlightColor;
		}
	};

	private int getCaretOffset() {
		if (text.isFocusControl())
			return text.getCaretOffset();
		else
			return preservedCaretOffset;
	}

	private void setCaretOffset(int position) {
		text.setCaretOffset(position);
		preservedCaretOffset = position;
	}

	private void setStatus(String error) {
		lblStatus.setText(error);
		compositeStatusAndClose.layout();
	}

	private Pattern compilePattern() {
		String needle = textFind.getText().trim();
		if (needle.length() == 0)
			return null;
		String regexp;
		if (btnCheckWholeWord.getSelection())
			regexp = "\\b(" + Pattern.quote(needle) + ")\\b";
		else if (!btnCheckRegexp.getSelection())
			regexp = Pattern.quote(needle);
		else
			regexp = needle;
		try {
			return Pattern.compile(regexp, (!btnCheckCaseSensitive.getSelection()) ? Pattern.CASE_INSENSITIVE : 0);
		} catch (PatternSyntaxException pse) {
			String error = "Regex error: " + pse.getMessage();
			setStatus(error);
			return null;
		}
	}

	private void clearAll() {
		setStatus("");
		matches = null;
		text.setSelectionRange(0, 0);
		btnReplace.setEnabled(false);
		btnReplaceFind.setEnabled(false);
	}

	private class Match {
		public int start;
		public int end;

		public Match(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	private void buildSearchResults() {
		matches = new Vector<Match>();
		Pattern pattern = compilePattern();
		if (pattern == null)
			return;
		Matcher matcher = pattern.matcher(text.getText());
		if (btnRadioSelected.getSelection())
			while (matcher.find()) {
				if (!isOverlappingOriginalSelectionLineOffsetRange(matcher.start(), matcher.end() - matcher.start()))
					continue;
				matches.add(new Match(matcher.start(), matcher.end()));
			}
		else
			while (matcher.find())
				matches.add(new Match(matcher.start(), matcher.end()));
	}

	private void doFindInternal() {
		if (getCaretOffset() >= text.getCharCount())
			setCaretOffset(0);
		if (matches == null)
			buildSearchResults();
		if (matches.size() == 0) {
			setStatus("Not found.");
			return;
		}
		if (lastFindIndex >= matches.size()) {
			if (btnCheckWrapsearch.getSelection()) {
				lastFindIndex = 0;
				setStatus("Wrapped to the beginning.");
			} else {
				lastFindIndex = matches.size() - 1;
				setStatus("Reached the end.");
				return;
			}
		} else if (lastFindIndex < 0) {
			if (btnRadioForward.getSelection()) {
				lastFindIndex = 0;
				for (Match match : matches) {
					if (match.start >= getCaretOffset())
						break;
					lastFindIndex++;
				}
				if (lastFindIndex >= matches.size())
					lastFindIndex = matches.size() - 1;
			} else {
				lastFindIndex = matches.size() - 1;
				while (lastFindIndex > 0) {
					Match match = matches.get(lastFindIndex);
					if (match.start <= getCaretOffset())
						break;
					lastFindIndex--;
				}
			}
		}
		Match match = matches.get(lastFindIndex);
		text.setSelection(match.start, match.end);
		setCaretOffset(match.end);
		btnReplace.setEnabled(true);
		btnReplaceFind.setEnabled(true);
	}

	private void doFind() {
		setStatus("");
		if (lastReplacementRange != null) {
			text.setSelectionRange(lastReplacementRange.x, lastReplacementRange.y);
			setCaretOffset(lastReplacementRange.x + lastReplacementRange.y);
			lastReplacementRange = null;
		} else
			doFindInternal();
	}

	private void doFindNext() {
		setStatus("");
		if (lastFindIndex >= 0) {
			if (btnRadioForward.getSelection())
				lastFindIndex++;
			else {
				lastFindIndex--;
				if (lastFindIndex < 0) {
					if (btnCheckWrapsearch.getSelection()) {
						lastFindIndex = matches.size() - 1;
						setStatus("Wrapped to the end.");
					} else {
						lastFindIndex = 0;
						setStatus("Reached the beginning.");
						return;
					}
				}
			}
		}
		doFindInternal();
	}

	protected void doReplaceAll() {
		setStatus("");
		Pattern pattern = compilePattern();
		if (pattern == null)
			return;
		String haystack = text.getText();
		long hitCount = 0;
		Matcher matcher = pattern.matcher(haystack);
		StringBuffer changeBuffer = new StringBuffer();
		while (matcher.find()) {
			if (btnRadioSelected.getSelection())
				if (!isOverlappingOriginalSelectionLineOffsetRange(matcher.start(), matcher.end() - matcher.start()))
					continue;
			matcher.appendReplacement(changeBuffer, textReplace.getText());
			hitCount++;
		}
		matcher.appendTail(changeBuffer);

		text.removeExtendedModifyListener(textModifyListener);
		int topLine = text.getTopIndex();
		text.setText(changeBuffer.toString());
		text.redraw();
		text.setTopIndex(topLine);
		text.addExtendedModifyListener(textModifyListener);

		if (hitCount == 0)
			setStatus("Not found.");
		else if (hitCount == 1)
			setStatus(hitCount + " match replaced.");
		else
			setStatus(hitCount + " matches replaced.");
	}

	protected void doReplace() {
		setStatus("");
		Pattern pattern = compilePattern();
		if (pattern == null)
			return;
		String haystack = text.getSelectionText();
		Matcher matcher = pattern.matcher(haystack);
		StringBuffer changeBuffer = new StringBuffer();
		if (matcher.find())
			matcher.appendReplacement(changeBuffer, textReplace.getText());
		else {
			setStatus("Not found.");
			return;
		}
		int start = text.getSelectionRange().x;
		int length = text.getSelectionRange().y;
		text.replaceTextRange(start, length, changeBuffer.toString());
		int replacementLength = changeBuffer.toString().length();
		lastReplacementRange = new Point(start, replacementLength);
		setCaretOffset(start + replacementLength);
		lastFindIndex = -1;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setText("Find/Replace");
		shell.setLayout(new FormLayout());

		Composite searchTextPanel = new Composite(shell, SWT.None);
		searchTextPanel.setLayout(new GridLayout(3, false));
		FormData fd_searchTextPanel = new FormData();
		fd_searchTextPanel.right = new FormAttachment(100);
		fd_searchTextPanel.top = new FormAttachment(0);
		fd_searchTextPanel.left = new FormAttachment(0);
		searchTextPanel.setLayoutData(fd_searchTextPanel);

		new Label(searchTextPanel, SWT.NONE);
		lblFind = new Label(searchTextPanel, SWT.NONE);
		lblFind.setText("Find:");
		lblFind.setAlignment(SWT.RIGHT);
		lblFind.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		textFind = new Text(searchTextPanel, SWT.BORDER);
		textFind.addModifyListener(e -> {
			boolean findEmpty = textFind.getText().isEmpty();
			btnFind.setEnabled(!findEmpty);
			btnReplaceAll.setEnabled(!findEmpty);
			clearAll();
			if (!btnCheckIncremental.getSelection())
				return;
			doFind();
		});
		textFind.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == '\r')
					doFindNext();
			}
		});
		textFind.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		new Label(searchTextPanel, SWT.NONE);
		lblReplace = new Label(searchTextPanel, SWT.NONE);
		lblReplace.setText("Replace with:");
		lblReplace.setAlignment(SWT.RIGHT);
		lblReplace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		textReplace = new Text(searchTextPanel, SWT.BORDER);
		textReplace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite contentPanel = new Composite(shell, SWT.NONE);
		contentPanel.setLayout(new GridLayout(3, false));
		FormData fd_contentPanel = new FormData();
		fd_contentPanel.top = new FormAttachment(searchTextPanel);
		fd_contentPanel.left = new FormAttachment(0);
		fd_contentPanel.right = new FormAttachment(100);
		contentPanel.setLayoutData(fd_contentPanel);

		compositeDirectionScope = new Composite(contentPanel, SWT.NONE);
		compositeDirectionScope.setLayout(new FillLayout(SWT.HORIZONTAL));
		compositeDirectionScope.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		grpDirection = new Group(compositeDirectionScope, SWT.NONE);
		grpDirection.setText("Direction");
		grpDirection.setLayout(new RowLayout(SWT.VERTICAL));

		btnRadioForward = new Button(grpDirection, SWT.RADIO);
		btnRadioForward.setSelection(true);
		btnRadioForward.setText("Forward");

		btnRadioBackward = new Button(grpDirection, SWT.RADIO);
		btnRadioBackward.setText("Backward");

		grpScope = new Group(compositeDirectionScope, SWT.NONE);
		grpScope.setText("Scope");
		grpScope.setLayout(new RowLayout(SWT.VERTICAL));

		btnRadioAll = new Button(grpScope, SWT.RADIO);
		btnRadioAll.setText("All");
		btnRadioAll.addListener(SWT.Selection, e -> {
			lastFindIndex = -1;
			refreshText();
			clearAll();
			doFind();
		});
		btnRadioAll.setSelection(true);

		btnRadioSelected = new Button(grpScope, SWT.RADIO);
		btnRadioSelected.setText("Selected lines");
		btnRadioSelected.addListener(SWT.Selection, e -> {
			lastFindIndex = -1;
			refreshText();
			clearAll();
			doFind();
		});

		compositeOptions = new Composite(contentPanel, SWT.NONE);
		compositeOptions.setLayout(new FillLayout(SWT.HORIZONTAL));
		compositeOptions.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));

		grpOptions = new Group(compositeOptions, SWT.NONE);
		grpOptions.setText("Options");
		grpOptions.setLayout(new GridLayout(2, false));

		btnCheckCaseSensitive = new Button(grpOptions, SWT.CHECK);
		btnCheckCaseSensitive.setText("Case sensitive");
		btnCheckCaseSensitive.addListener(SWT.Selection, e -> {
			clearAll();
			doFind();
		});

		btnCheckWholeWord = new Button(grpOptions, SWT.CHECK);
		btnCheckWholeWord.setText("Whole word");
		btnCheckWholeWord.addListener(SWT.Selection, e -> {
			clearAll();
			doFind();
		});

		btnCheckRegexp = new Button(grpOptions, SWT.CHECK);
		btnCheckRegexp.setText("Regular expressions");
		btnCheckRegexp.addListener(SWT.Selection, e -> {
			clearAll();
			doFind();
			btnCheckIncremental.setEnabled(!btnCheckRegexp.getSelection());
			btnCheckWholeWord.setEnabled(!btnCheckRegexp.getSelection());
		});

		btnCheckWrapsearch = new Button(grpOptions, SWT.CHECK);
		btnCheckWrapsearch.setText("Wrap search");

		btnCheckIncremental = new Button(grpOptions, SWT.CHECK);
		btnCheckIncremental.setText("Incremental");
		btnCheckIncremental.addListener(SWT.Selection, e -> {
			clearAll();
			doFind();
		});
		new Label(grpOptions, SWT.NONE);

		compositeButtons = new Composite(contentPanel, SWT.NONE);
		compositeButtons.setLayout(new GridLayout(3, true));
		compositeButtons.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));

		btnFind = new Button(compositeButtons, SWT.NONE);
		btnFind.setText("Find");
		btnFind.setEnabled(false);
		btnFind.addListener(SWT.Selection, e -> doFindNext());
		btnFind.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		new Label(compositeButtons, SWT.NONE);

		Composite composite = new Composite(compositeButtons, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		btnReplaceFind = new Button(compositeButtons, SWT.NONE);
		btnReplaceFind.setText("Replace/Find");
		btnReplaceFind.setEnabled(false);
		btnReplaceFind.addListener(SWT.Selection, e -> {
			doReplace();
			doFindNext();
		});
		btnReplaceFind.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		btnReplace = new Button(compositeButtons, SWT.NONE);
		btnReplace.setText("Replace");
		btnReplace.setEnabled(false);
		btnReplace.addListener(SWT.Selection, e -> doReplace());
		btnReplace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		btnReplaceAll = new Button(compositeButtons, SWT.NONE);
		btnReplaceAll.setText("Replace All");
		btnReplaceAll.setEnabled(false);
		btnReplaceAll.addListener(SWT.Selection, e -> doReplaceAll());
		btnReplaceAll.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

		compositeStatusAndClose = new Composite(shell, SWT.NONE);
		fd_contentPanel.bottom = new FormAttachment(compositeStatusAndClose);
		FormData fd_compositeStatusAndClose = new FormData();
		fd_compositeStatusAndClose.bottom = new FormAttachment(100);
		fd_compositeStatusAndClose.right = new FormAttachment(100);
		fd_compositeStatusAndClose.left = new FormAttachment(0);
		compositeStatusAndClose.setLayoutData(fd_compositeStatusAndClose);
		compositeStatusAndClose.setLayout(new GridLayout(2, false));

		lblStatus = new Label(compositeStatusAndClose, SWT.WRAP);
		lblStatus.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));

		Button btnClose = new Button(compositeStatusAndClose, SWT.RIGHT);
		btnClose.setText("Close");
		btnClose.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnClose.setAlignment(SWT.CENTER);
		btnClose.setFocus();
		btnClose.setSize(btnClose.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		btnClose.addListener(SWT.Selection, e -> shell.dispose());

		shell.addDisposeListener(e -> {
			text.removeExtendedModifyListener(textModifyListener);
			text.removeSelectionListener(textSelectionListener);
			text.removeFocusListener(textFocusListener);
			text.removeLineBackgroundListener(textLineBackgroundListener);
			refreshText();
			text.setFocus();
		});

		shell.pack();
	}
}
