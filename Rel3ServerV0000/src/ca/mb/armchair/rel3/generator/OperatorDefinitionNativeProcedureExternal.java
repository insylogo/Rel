package ca.mb.armchair.rel3.generator;

import java.lang.reflect.*;

import ca.mb.armchair.rel3.types.Type;
import ca.mb.armchair.rel3.exceptions.ExceptionSemantic;
import ca.mb.armchair.rel3.vm.Context;
import ca.mb.armchair.rel3.vm.instructions.system.OpJavaCall;

/** This class captures information about the native procedure currently being defined.
 * 
 * @author dave
 *
 */
public class OperatorDefinitionNativeProcedureExternal extends OperatorDefinitionNative {
	
	private Method method;

	/** Ctor for operator definition, with resolved class. */
	public OperatorDefinitionNativeProcedureExternal(OperatorSignature sig, Method method) {
		super(sig.getName(), sig.getParameterTypes());
		this.method = method;
	}
	
	/** Get primary language. */
	public String getLanguage() {
		return "JavaP";
	}

	private void noEvaluate() {
		throw new ExceptionSemantic("RS0094: Attempt to evaluate " + getSignature() + " which does not have a return value.");		
	}
	
	public void compileCall(Generator generator) {
		generator.compileInstruction(new OpJavaCall(method));
	}
	
	public Type compileEvaluate(Generator generator) {
		noEvaluate();
		return null;
	}

	public void call(Context context) {
		(new OpJavaCall(method)).execute(context);
	}

	public void evaluate(Context context) {
		noEvaluate();
	}
	
}
