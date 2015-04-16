package org.reldb.rel.v1.vm.instructions.relation;

import org.reldb.rel.v1.values.ValueRelation;
import org.reldb.rel.v1.vm.Context;
import org.reldb.rel.v1.vm.Instruction;

public class OpRelationXunion extends Instruction {

	@Override
	public void execute(Context context) {
	    // Relation XUNION.
	    // POP - ValueRelation
	    // POP - ValueRelation
	    // PUSH - ValueRelation
		ValueRelation v2 = (ValueRelation)context.pop();
		context.push(((ValueRelation)context.pop()).xunion(v2));
	}

}
