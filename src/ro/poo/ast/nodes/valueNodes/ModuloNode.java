package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.operations.Visitor;

/**
 * Minus node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class ModuloNode extends ValueNode {

	public ModuloNode(ASTNode parrent) {
		super(parrent);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}