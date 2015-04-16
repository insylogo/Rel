package org.reldb.rel.v1.vm.instructions.core;

import org.reldb.rel.v1.values.ValueInteger;
import org.reldb.rel.v1.vm.Context;
import org.reldb.rel.v1.vm.Instruction;

public final class OpAdd extends Instruction {
	public final void execute(Context context) {
		context.push(ValueInteger.select(context.getGenerator(), context.pop().longValue() + context.pop().longValue()));
	}
}
