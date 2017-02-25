package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * Main node of the AST
 * 
 * @author Alexandru Lincan
 *
 */
public class MainNode extends ASTNode {

	public MainNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}