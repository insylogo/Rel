package org.reldb.dbrowser.handlers;

import java.lang.reflect.Method;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public abstract class EditMenuItem extends MenuItemWithToolbar {
	private String editMethodName;
	
	public EditMenuItem(String editMethodName) {
		this.editMethodName = editMethodName;
	}
	
	public String getEditMethodName() {
		return editMethodName;
	}
	
	protected static Control getControl() {
		return Display.getCurrent().getFocusControl();		
	}
	
	protected static Method getMethod(String methodName) {
		Control control = getControl();
		try {
			Method method = control.getClass().getMethod(methodName, new Class<?>[0]);
			return method;
		} catch (NoSuchMethodException | SecurityException e) {
			return null;
		}		
	}
	
	protected static boolean doMethod(String methodName) {
		Method method = getMethod(methodName);
		if (method != null)
			try {
				method.invoke(getControl(), new Object[0]);
				return true;
			} catch (Throwable e) {
				System.out.println("EditMenuItem: doMethod exception: " + e);
			}
		return false;
	}
	
	protected boolean doDefaultMethod() {
		return doMethod(editMethodName);
	}

	protected Method getDefaultMethod() {
		return getMethod(editMethodName);
	}
	
	@CanExecute
	public boolean canExecute(MHandledMenuItem item) {
		if (super.canExecute(item))
			return true;
		return getDefaultMethod() != null;
	}
	
	@Execute
	public void execute() {
		if (doExecute())
			return;
		doDefaultMethod();
	}
}
