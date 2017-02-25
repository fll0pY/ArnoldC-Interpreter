package ro.poo.ast.nodes.whileNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * While node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class WhileNode extends ASTNode {

	public WhileNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
