package ro.poo.ast.nodes.ifNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * If node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class IfNode extends ASTNode {

	public IfNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
