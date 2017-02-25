package ro.poo.ast.nodes.ifNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * IfBody node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class IfBodyNode extends ASTNode {

	public IfBodyNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
