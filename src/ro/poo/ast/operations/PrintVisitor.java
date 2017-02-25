package ro.poo.ast.operations;

import java.util.ArrayList;

import ro.poo.OutputWriter;
import ro.poo.ast.nodes.*;
import ro.poo.ast.nodes.ifNodes.*;
import ro.poo.ast.nodes.valueNodes.*;
import ro.poo.ast.nodes.variables.*;
import ro.poo.ast.nodes.whileNodes.*;

/**
 * Visitor class for printing the AST
 * 
 * @author Alexandru Lincan
 *
 */
public class PrintVisitor implements Visitor {

	private OutputWriter output;

	public PrintVisitor(String outputFile) {
		output = new OutputWriter(outputFile);
	}

	private void printHierarchy(ASTNode root, int level) {
		String toPrint = new String();
		toPrint = "";
		for (int i = 0; i < level; i++) {
			toPrint += '\t';
		}
		output.print(toPrint);
		root.accept(this);

		ArrayList<ASTNode> children = root.getChildren();
		for (ASTNode node : children) {
			printHierarchy(node, level + 1);
		}
	}

	private String getNodeName(ASTNode node) {
		String toPrint = node.getClass().getName();
		toPrint = toPrint.substring(toPrint.lastIndexOf('.') + 1);
		return toPrint;
	}

	@Override
	public void visit(MainNode mainNode) {
		output.printLine(getNodeName(mainNode));
		ArrayList<ASTNode> children = mainNode.getChildren();
		for (ASTNode node : children) {
			printHierarchy(node, 1);
		}
		output.closeWriter();
	}

	@Override
	public void visit(PrintNode printNode) {
		output.printLine(getNodeName(printNode));
	}

	@Override
	public void visit(DeclareNode declareNode) {
		output.printLine(getNodeName(declareNode));
	}

	@Override
	public void visit(AssignmentNode assigmentNode) {
		output.printLine(getNodeName(assigmentNode));
	}

	@Override
	public void visit(ConditionNode conditionNode) {
		output.printLine(getNodeName(conditionNode) + " <"
				+ conditionNode.getName() + ">");
	}

	@Override
	public void visit(IfNode ifNode) {
		output.printLine(getNodeName(ifNode));
	}

	@Override
	public void visit(IfBodyNode ifBodyNode) {
		output.printLine(getNodeName(ifBodyNode));
	}

	@Override
	public void visit(ElseBodyNode elseBodyNode) {
		output.printLine(getNodeName(elseBodyNode));
	}

	@Override
	public void visit(BodyNode bodyNode) {
		output.printLine(getNodeName(bodyNode));
	}

	@Override
	public void visit(WhileNode whileNode) {
		output.printLine(getNodeName(whileNode));
	}

	@Override
	public void visit(LvalNode lvalNode) {
		output.printLine(
				getNodeName(lvalNode) + " <" + lvalNode.getName() + ">");
	}

	@Override
	public void visit(RvalNode rvalNode) {
		output.printLine(
				getNodeName(rvalNode) + " <" + rvalNode.getName() + ">");
	}

	@Override
	public void visit(AndNode andNode) {
		output.printLine(getNodeName(andNode));
	}

	@Override
	public void visit(ConstantNode constantNode) {
		output.printLine(getNodeName(constantNode) + " <"
				+ new Integer(constantNode.getValue()).toString() + ">");
	}

	@Override
	public void visit(DivisionNode divisionNode) {
		output.printLine(getNodeName(divisionNode));
	}

	@Override
	public void visit(EqualToNode equalToNode) {
		output.printLine(getNodeName(equalToNode));
	}

	@Override
	public void visit(GreaterThanNode greaterThanNode) {
		output.printLine(getNodeName(greaterThanNode));
	}

	@Override
	public void visit(DifferenceNode differenceNode) {
		output.printLine(getNodeName(differenceNode));
	}

	@Override
	public void visit(ModuloNode moduloNode) {
		output.printLine(getNodeName(moduloNode));
	}

	@Override
	public void visit(MultiplicationNode multiplicationNode) {
		output.printLine(getNodeName(multiplicationNode));
	}

	@Override
	public void visit(OrNode orNode) {
		output.printLine(getNodeName(orNode));
	}

	@Override
	public void visit(SumNode sumNode) {
		output.printLine(getNodeName(sumNode));
	}

	@Override
	public void visit(StringNode stringNode) {
		output.printLine(
				getNodeName(stringNode) + " <" + stringNode.getText() + ">");
	}

	@Override
	public void visit(VariableNode variableNode) {
		output.printLine(getNodeName(variableNode) + " <"
				+ variableNode.getName() + ">");
	}
}