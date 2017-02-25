package ro.poo.ast.nodes;

import java.util.ArrayList;

/**
 * Abstract class for AST nodes
 * 
 * @author Alexandru Lincan
 *
 */
public abstract class ASTNode implements Visitable {
	protected ASTNode parrent;
	protected ArrayList<ASTNode> children;

	/**
	 * Default constructor for nodes
	 * 
	 */
	public ASTNode(ASTNode parrent) {
		this.parrent = parrent;
		children = new ArrayList<ASTNode>();
	}

	/**
	 * Changes the parrent of this node
	 * 
	 * @param newParrent
	 */
	public void setParrent(ASTNode newParrent) {
		this.parrent = newParrent;
	}

	/**
	 * Add a new child
	 * 
	 * @param node
	 */
	public void addChild(ASTNode node) {
		children.add(node);
	}

	/**
	 * Push Front a child node
	 * 
	 * @param node
	 */
	public void addChildAtFront(ASTNode node) {
		children.add(0, node);
	}

	/**
	 * Returns the list of children
	 * 
	 * @return the list of children
	 */
	public ArrayList<ASTNode> getChildren() {
		return children;
	}
}
