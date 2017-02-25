package ro.poo.ast.nodes.variables;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Condition node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class ConditionNode extends VariableNode {

	public ConditionNode(ASTNode parrent, String variable) {
		super(parrent, variable);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
