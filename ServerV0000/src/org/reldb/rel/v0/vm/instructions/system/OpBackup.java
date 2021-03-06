/**
 * 
 */
package org.reldb.rel.v0.vm.instructions.system;

import org.reldb.rel.v0.backup.Backup;
import org.reldb.rel.v0.vm.Context;
import org.reldb.rel.v0.vm.Instruction;
import org.reldb.rel.v0.vm.VirtualMachine;

public final class OpBackup extends Instruction {

	public final void execute(Context context) {
		VirtualMachine vm = context.getVirtualMachine();
		Backup.backup(vm.getRelDatabase(), vm.getPrintStream());
	}
}
