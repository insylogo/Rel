package org.reldb.rel.v1.vm.instructions.core;

import java.io.PrintStream;

import org.reldb.rel.v1.types.Type;
import org.reldb.rel.v1.vm.Context;
import org.reldb.rel.v1.vm.Instruction;

public class OpWrite extends Instruction {
	
	private Type type;
	
	public OpWrite(Type type) {
		this.type = type;
	}
	
	public final void execute(Context context) {
		PrintStream output = context.getVirtualMachine().getPrintStream();
		context.pop().toStream(context, type, output, 0);
		output.flush();
	}
}
