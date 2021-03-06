/**
 * 
 */
package org.reldb.rel.v0.vm.instructions.array;

import org.reldb.rel.v0.values.*;
import org.reldb.rel.v0.vm.Context;
import org.reldb.rel.v0.vm.Instruction;

public final class OpArrayGet extends Instruction {
	
	public final void execute(Context context) {
	    // Obtain value at given subscript in an array
	    //
	    // POP - ValueInteger - subscript
	    // POP - ValueArray - array
	    // PUSH - Value
    	int subscript = (int)((ValueInteger)context.pop()).longValue();
    	ValueArray array = (ValueArray)context.pop();
    	context.push(array.get(subscript));
	}
}