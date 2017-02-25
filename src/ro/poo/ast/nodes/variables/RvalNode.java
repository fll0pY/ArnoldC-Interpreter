package ro.poo.ast.nodes.variables;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Right value node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class RvalNode extends VariableNode {

	public RvalNode(ASTNode parrent, String variable) {
		super(parrent, variable);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}