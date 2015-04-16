/**
 * 
 */
package org.reldb.rel.v1.vm.instructions.system;

import org.reldb.rel.v1.vm.Context;
import org.reldb.rel.v1.vm.Instruction;

public final class OpTransactionBegin extends Instruction {

	public final void execute(Context context) {
	    // BEGIN TRANSACTION
		context.getVirtualMachine().getRelDatabase().beginTransaction();
	}
}
