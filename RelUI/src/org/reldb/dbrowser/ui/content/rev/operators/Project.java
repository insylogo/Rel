package org.reldb.dbrowser.ui.content.rev.operators;

import org.reldb.dbrowser.ui.content.rev.Operator;
import org.reldb.dbrowser.ui.content.rev.Parameter;
import org.reldb.dbrowser.ui.content.rev.Rev;

public class Project extends Operator {

	public Project(Rev rev, String name, int xpos, int ypos) {
		super(rev.getModel(), name, "Project", xpos, ypos);
		addParameter("Operand", "Relation passed to " + getKind()); 
	}
	
	@Override
    protected void notifyArgumentChanged(Parameter p, boolean queryable) {
		
	}

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}
