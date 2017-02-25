package ro.poo.ast.nodes.whileNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * While body node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class BodyNode extends ASTNode {

	public BodyNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
