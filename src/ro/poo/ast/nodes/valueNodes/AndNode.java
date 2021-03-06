package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * And node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class AndNode extends ValueNode {

	public AndNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
