package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Constant node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class ConstantNode extends ValueNode {

	public ConstantNode(ASTNode parrent, int value) {
		super(parrent, value);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}