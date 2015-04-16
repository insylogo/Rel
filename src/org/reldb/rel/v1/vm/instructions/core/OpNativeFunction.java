/**
 * 
 */
package org.reldb.rel.v1.vm.instructions.core;

import org.reldb.rel.v1.vm.Context;
import org.reldb.rel.v1.vm.Instruction;
import org.reldb.rel.v1.vm.NativeFunction;

public final class OpNativeFunction extends Instruction {

	private NativeFunction function;
	private int parmCount;
	
	public OpNativeFunction(NativeFunction function, int parmCount) {
		this.function = function;
		this.parmCount = parmCount;
	}
	
	public final void execute(Context context) {
		context.userFunction(function, parmCount);
	}
}