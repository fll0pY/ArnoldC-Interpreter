package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * EqualTo node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class EqualToNode extends ValueNode {

	public EqualToNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
