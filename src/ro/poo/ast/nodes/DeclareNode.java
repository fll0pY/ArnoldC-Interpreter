package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * Declare node of the AST
 * 
 * @author Alexandru Lincan
 *
 */
public class DeclareNode extends ASTNode {

	public DeclareNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
