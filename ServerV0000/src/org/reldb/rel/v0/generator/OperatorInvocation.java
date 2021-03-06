/**
 * 
 */
package org.reldb.rel.v0.generator;

public class OperatorInvocation {
	
	private OperatorDefinition staticOperatorDefinition = null;
	private OperatorSignature operatorSignature = null;

	public OperatorInvocation(OperatorSignature opSig) {
		operatorSignature = opSig;
		staticOperatorDefinition = null;
	}

	public OperatorInvocation(OperatorDefinition opDef) {
		staticOperatorDefinition = opDef;
		operatorSignature = null;
	}
	
	public boolean useDynamicDispatch() {
		return operatorSignature != null;
	}

	public OperatorDefinition getStaticOperatorDefinition() {
		return staticOperatorDefinition;
	}

	public OperatorSignature getOperatorSignature() {
		return operatorSignature;
	}
	
}