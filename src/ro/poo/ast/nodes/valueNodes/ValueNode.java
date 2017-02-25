package ro.poo.ast.nodes.valueNodes;

import ro.poo.ast.nodes.ASTNode;

/**
 * Abstract class for operations that returns a value or constants leaves
 * 
 * @author Alexandru Lincan
 *
 */
public abstract class ValueNode extends ASTNode {
	private int value;

	public ValueNode(ASTNode parrent) {
		super(parrent);
		this.value = 0;
	}

	/**
	 * Initialises a ValueNode with a specific value
	 * 
	 * @param parrent
	 * @param value
	 */
	public ValueNode(ASTNode parrent, int value) {
		super(parrent);
		this.value = value;
	}

	/**
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Returns the value of the node
	 * 
	 * @return the value of the node
	 */
	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return new Integer(value).toString();
	}
}