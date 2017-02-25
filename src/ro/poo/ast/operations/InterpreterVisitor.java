package ro.poo.ast.operations;

import java.util.ArrayList;
import java.util.HashMap;

import ro.poo.OutputWriter;
import ro.poo.Variables;
import ro.poo.ast.nodes.*;
import ro.poo.ast.nodes.ifNodes.*;
import ro.poo.ast.nodes.valueNodes.*;
import ro.poo.ast.nodes.variables.*;
import ro.poo.ast.nodes.whileNodes.*;

/**
 * Visitor class for interpreting the AST
 * 
 * @author Alexandru Lincan
 *
 */
public class InterpreterVisitor implements Visitor {
	private OutputWriter output;

	public InterpreterVisitor(String outputFile) {
		output = new OutputWriter(outputFile);
	}

	@Override
	public void visit(MainNode mainNode) {
		ArrayList<ASTNode> children = mainNode.getChildren();
		for (ASTNode node : children) {
			node.accept(this);
		}
		output.closeWriter();
	}

	@Override
	public void visit(PrintNode printNode) {
		ArrayList<ASTNode> children = printNode.getChildren();
		children.get(0).accept(this);
		output.printLine(children.get(0).toString());
	}

	@Override
	public void visit(DeclareNode declareNode) {
		Variables var = Variables.getInstance();
		HashMap<String, Integer> varMap = var.getVariablesMap();
		ArrayList<ASTNode> children = declareNode.getChildren();
		varMap.put(((LvalNode) children.get(0)).getName(),
				((ConstantNode) children.get(1)).getValue());
	}

	@Override
	public void visit(AssignmentNode assigmentNode) {
		Variables var = Variables.getInstance();
		HashMap<String, Integer> varMap = var.getVariablesMap();
		ArrayList<ASTNode> children = assigmentNode.getChildren();
		children.get(1).accept(this);
		varMap.put(((VariableNode) children.get(0)).getName(),
				((ValueNode) children.get(1)).getValue());
	}

	@Override
	public void visit(ConditionNode conditionNode) {
		visit((VariableNode) conditionNode);
	}

	@Override
	public void visit(IfNode ifNode) {
		ArrayList<ASTNode> children = ifNode.getChildren();
		children.get(0).accept(this);
		IfBodyNode bodyNode = (IfBodyNode) children.get(1);
		ElseBodyNode elseBody = null;
		if (children.size() > 2) {
			elseBody = (ElseBodyNode) children.get(2);
		}
		if (((ConditionNode) children.get(0)).getValue() != 0) {
			bodyNode.accept(this);
		} else {
			if (elseBody != null) {
				elseBody.accept(this);
			}
		}
	}

	@Override
	public void visit(IfBodyNode ifBodyNode) {
		ArrayList<ASTNode> children = ifBodyNode.getChildren();
		for (ASTNode node : children) {
			node.accept(this);
		}
	}

	@Override
	public void visit(ElseBodyNode elseBodyNode) {
		ArrayList<ASTNode> children = elseBodyNode.getChildren();
		for (ASTNode node : children) {
			node.accept(this);
		}
	}

	@Override
	public void visit(BodyNode bodyNode) {
		ArrayList<ASTNode> children = bodyNode.getChildren();
		for (ASTNode node : children) {
			node.accept(this);
		}
	}

	@Override
	public void visit(WhileNode whileNode) {
		ArrayList<ASTNode> children = whileNode.getChildren();
		ConditionNode condNode = (ConditionNode) children.get(0);
		condNode.accept(this);
		BodyNode bodyNode = (BodyNode) children.get(1);
		int condition = condNode.getValue();
		while (condition != 0) {
			bodyNode.accept(this);
			condNode.accept(this);
			condition = condNode.getValue();
		}
	}

	@Override
	public void visit(LvalNode lvalNode) {
		visit((VariableNode) lvalNode);
	}

	@Override
	public void visit(RvalNode rvalNode) {
		visit((VariableNode) rvalNode);
	}

	@Override
	public void visit(AndNode andNode) {
		ArrayList<ASTNode> children = andNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		andNode.setValue((first != 0 && second != 0) ? 1 : 0);
	}

	@Override
	public void visit(ConstantNode constantNode) {
	}

	@Override
	public void visit(DivisionNode divisionNode) {
		ArrayList<ASTNode> children = divisionNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		divisionNode.setValue(first / second);
	}

	@Override
	public void visit(EqualToNode equalToNode) {
		ArrayList<ASTNode> children = equalToNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		equalToNode.setValue((first == second) ? 1 : 0);

	}

	@Override
	public void visit(GreaterThanNode greaterThanNode) {
		ArrayList<ASTNode> children = greaterThanNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		greaterThanNode.setValue((first > second) ? 1 : 0);
	}

	@Override
	public void visit(DifferenceNode differenceNode) {
		ArrayList<ASTNode> children = differenceNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		differenceNode.setValue(first - second);
	}

	@Override
	public void visit(ModuloNode moduloNode) {
		ArrayList<ASTNode> children = moduloNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		moduloNode.setValue(first % second);
	}

	@Override
	public void visit(MultiplicationNode multiplicationNode) {
		ArrayList<ASTNode> children = multiplicationNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		multiplicationNode.setValue(first * second);
	}

	@Override
	public void visit(OrNode orNode) {
		ArrayList<ASTNode> children = orNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		orNode.setValue((first != 0 || second != 0) ? 1 : 0);
	}

	@Override
	public void visit(SumNode sumNode) {
		ArrayList<ASTNode> children = sumNode.getChildren();
		children.get(0).accept(this);
		children.get(1).accept(this);
		int first = ((ValueNode) children.get(0)).getValue();
		int second = ((ValueNode) children.get(1)).getValue();
		sumNode.setValue(first + second);
	}

	@Override
	public void visit(StringNode stringNode) {
	}

	@Override
	public void visit(VariableNode variableNode) {
		Variables var = Variables.getInstance();
		HashMap<String, Integer> varMap = var.getVariablesMap();
		variableNode.setValue(varMap.get(variableNode.getName()));
	}
}
