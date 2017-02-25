package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Or node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class OrNode extends ValueNode {

	public OrNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}