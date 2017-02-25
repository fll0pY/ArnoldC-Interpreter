package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * String node for AST
 * 
 * @author Alexandru Lincan
 *
 */
public class StringNode extends ASTNode {
	private String text;

	public StringNode(ASTNode parrent, String text) {
		super(parrent);
		this.setText(text);
	}

	public StringNode(ASTNode parrent) {
		super(parrent);
		setText(null);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
