package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Multiplication node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class MultiplicationNode extends ValueNode {

	public MultiplicationNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
