package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * Assigment node of the AST
 * 
 * @author Alexandru Lincan
 *
 */
public class AssignmentNode extends ASTNode {

	public AssignmentNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
