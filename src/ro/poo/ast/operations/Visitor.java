package ro.poo.ast.operations;

import ro.poo.ast.nodes.*;
import ro.poo.ast.nodes.ifNodes.*;
import ro.poo.ast.nodes.valueNodes.*;
import ro.poo.ast.nodes.variables.*;
import ro.poo.ast.nodes.whileNodes.*;

/**
 * Interface for visitor objects
 * 
 * @author Alexandru Lincan
 *
 */
public interface Visitor {

	/**
	 * Visits a MainNode
	 * 
	 * @param mainNode
	 */
	public void visit(MainNode mainNode);

	/**
	 * Visits a PrintNode
	 * 
	 * @param printNode
	 */
	public void visit(PrintNode printNode);

	/**
	 * Visits a DeclareNode
	 * 
	 * @param declareNode
	 */
	public void visit(DeclareNode declareNode);

	/**
	 * Visits an AssigmentNode
	 * 
	 * @param assigmentNode
	 */
	public void visit(AssignmentNode assigmentNode);

	/**
	 * Visits a ConditionNode
	 * 
	 * @param conditionNode
	 */
	public void visit(ConditionNode conditionNode);

	/**
	 * Visits an IfNode
	 * 
	 * @param ifNode
	 */
	public void visit(IfNode ifNode);

	/**
	 * Visits an IfBodyNode
	 * 
	 * @param ifBodyNode
	 */
	public void visit(IfBodyNode ifBodyNode);

	/**
	 * Visits an ElseBodyNode
	 * 
	 * @param elseBodyNode
	 */
	public void visit(ElseBodyNode elseBodyNode);

	/**
	 * Visits a BodyNode
	 * 
	 * @param bodyNode
	 */
	public void visit(BodyNode bodyNode);

	/**
	 * Visits a WhileNode
	 * 
	 * @param whileNode
	 */
	public void visit(WhileNode whileNode);

	/**
	 * Visits a LvalNode
	 * 
	 * @param lvalNode
	 */
	public void visit(LvalNode lvalNode);

	/**
	 * Visits a RvalNode
	 * 
	 * @param rvalNode
	 */
	public void visit(RvalNode rvalNode);

	/**
	 * Visits an AndNode
	 * 
	 * @param andNode
	 */
	public void visit(AndNode andNode);

	/**
	 * Visits a ConstantNode
	 * 
	 * @param constantNode
	 */
	public void visit(ConstantNode constantNode);

	/**
	 * Visits a DivisionNode
	 * 
	 * @param divisionNode
	 */
	public void visit(DivisionNode divisionNode);

	/**
	 * Visits an EqualToNode
	 * 
	 * @param equalToNode
	 */
	public void visit(EqualToNode equalToNode);

	/**
	 * Visits a GreaterThanNode
	 * 
	 * @param greaterThanNode
	 */
	public void visit(GreaterThanNode greaterThanNode);

	/**
	 * Visits a MinusNode
	 * 
	 * @param differenceNode
	 */
	public void visit(DifferenceNode differenceNode);

	/**
	 * Visits a ModuloNode
	 * 
	 * @param moduloNode
	 */
	public void visit(ModuloNode moduloNode);

	/**
	 * Visits a MultiplicationNode
	 * 
	 * @param multiplicationNode
	 */
	public void visit(MultiplicationNode multiplicationNode);

	/**
	 * Visits an OrNode
	 * 
	 * @param orNode
	 */
	public void visit(OrNode orNode);

	/**
	 * Visits a PlusNode
	 * 
	 * @param sumNode
	 */
	public void visit(SumNode sumNode);

	/**
	 * Visit a StringNode
	 * 
	 * @param stringNode
	 */
	public void visit(StringNode stringNode);

	/**
	 * Visits a VariableNode
	 * 
	 * @param variableNode
	 */
	public void visit(VariableNode variableNode);
}