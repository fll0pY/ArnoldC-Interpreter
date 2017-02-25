package ro.poo.ast.nodes;

import ro.poo.ast.operations.Visitor;

/**
 * Interface for visitable objects
 * 
 * @author Alexandru Lincan
 *
 */
public interface Visitable {

	/**
	 * Accepts a visitor
	 * 
	 * @param v
	 *            the visitor to accept
	 */
	public void accept(Visitor v);
}
