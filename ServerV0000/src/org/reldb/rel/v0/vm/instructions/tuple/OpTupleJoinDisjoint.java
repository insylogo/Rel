/**
 * 
 */
package org.reldb.rel.v0.vm.instructions.tuple;

import org.reldb.rel.v0.vm.Context;
import org.reldb.rel.v0.vm.Instruction;

public final class OpTupleJoinDisjoint extends Instruction {

	public final void execute(Context context) {
		context.tupleJoinDisjoint();
	}
}