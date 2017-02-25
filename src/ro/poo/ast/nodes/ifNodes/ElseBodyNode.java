package ro.poo.ast.nodes.ifNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Else Body node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class ElseBodyNode extends ASTNode {

	public ElseBodyNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
