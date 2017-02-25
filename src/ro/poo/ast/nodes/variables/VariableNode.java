package ro.poo.ast.nodes.variables;

import ro.poo.ast.nodes.ASTNode;
import ro.poo.ast.nodes.valueNodes.ValueNode;
import ro.poo.ast.operations.Visitor;

/**
 * Abstract class for variables
 * 
 * @author Alexandru Lincan
 *
 */
public class VariableNode extends ValueNode {
	public VariableNode(ASTNode parrent, String variable) {
		super(parrent);
		this.name = variable;
	}

	private String name;

	/**
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
