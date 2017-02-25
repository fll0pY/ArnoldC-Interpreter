package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Greater than node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class GreaterThanNode extends ValueNode {

	public GreaterThanNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}