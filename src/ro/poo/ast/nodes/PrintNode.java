package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * Print node of AST
 * 
 * @author Alexandru Lincan
 *
 */
public class PrintNode extends ASTNode {

	public PrintNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
