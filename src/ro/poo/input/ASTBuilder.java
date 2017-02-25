package ro.poo.input;

import java.util.ArrayList;
import java.util.HashMap;

import ro.poo.Instructions;
import ro.poo.ast.nodes.*;
import ro.poo.ast.nodes.ifNodes.*;
import ro.poo.ast.nodes.valueNodes.*;
import ro.poo.ast.nodes.variables.*;
import ro.poo.ast.nodes.whileNodes.*;

/**
 * Class for building the Syntax Tree
 * 
 * @author Alexandru Lincan
 *
 */
public class ASTBuilder {
	/**
	 * Hash for mapping the instruction name with an instruction type
	 */
	public static final HashMap<String, Instructions> instructionsSet = new HashMap<String, Instructions>();
	static {
		instructionsSet.put("I LIED", Instructions.FALSE);
		instructionsSet.put("NO PROBLEMO", Instructions.TRUE);
		instructionsSet.put("BECAUSE I'M GOING TO SAY PLEASE", Instructions.IF);
		instructionsSet.put("BULLSHIT", Instructions.ELSE);
		instructionsSet.put("YOU HAVE NO RESPECT FOR LOGIC",
				Instructions.END_IF);
		instructionsSet.put("CHILL", Instructions.END_WHILE);
		instructionsSet.put("STICK AROUND", Instructions.WHILE);
		instructionsSet.put("GET UP", Instructions.PLUS_OPERATOR);
		instructionsSet.put("GET DOWN", Instructions.MINUS_OPERATOR);
		instructionsSet.put("YOU'RE FIRED",
				Instructions.MULTIPLICATION_OPERATOR);
		instructionsSet.put("HE HAD TO SPLIT", Instructions.DIVISION_OPERATOR);
		instructionsSet.put("I LET HIM GO", Instructions.MODULO_OPERATOR);
		instructionsSet.put("YOU ARE NOT YOU YOU ARE ME",
				Instructions.EQUAL_TO);
		instructionsSet.put("LET OFF SOME STEAM BENNET",
				Instructions.GREATER_THAN);
		instructionsSet.put("CONSIDER THAT A DIVORCE", Instructions.OR);
		instructionsSet.put("KNOCK KNOCK", Instructions.AND);
		instructionsSet.put("HEY CHRISTMAS TREE", Instructions.DECLARE_INT);
		instructionsSet.put("YOU SET US UP", Instructions.SET_INITIAL_VALUE);
		instructionsSet.put("IT'S SHOWTIME", Instructions.BEGIN_MAIN);
		instructionsSet.put("YOU HAVE BEEN TERMINATED", Instructions.END_MAIN);
		instructionsSet.put("TALK TO THE HAND", Instructions.PRINT);
		instructionsSet.put("GET TO THE CHOPPER", Instructions.ASSIGN_VARIABLE);
		instructionsSet.put("HERE IS MY INVITATION", Instructions.SET_VALUE);
		instructionsSet.put("ENOUGH TALK", Instructions.END_ASSIGN_VARIABLE);
	}

	private InputParser inputParser;
	private String currInstruction;

	/**
	 * Initialises an InputParser for the given inputFile
	 * 
	 * @param inputFile
	 */
	public ASTBuilder(String inputFile) {
		inputParser = new InputParser(inputFile);
	}

	/**
	 * Constructs an AST tree
	 */
	public MainNode constructAST() {
		MainNode mainNode = new MainNode(null);

		currInstruction = inputParser.getInstruction();
		while (instructionsSet.get(currInstruction) != Instructions.END_MAIN) {
			currInstruction = inputParser.getInstruction();
			chooseInstruction(mainNode);
		}
		return mainNode;
	}

	private String getVariableArg(String instruction) {
		return instruction.substring(instruction.lastIndexOf(' ') + 1);
	}

	private int getValueArg(String instruction) {
		int value = 0;
		String arg;
		if (instruction.indexOf('@') != -1) {
			arg = instruction.substring(instruction.indexOf('@') + 1);
			arg.trim();
			if (arg.equals(Instructions.FALSE.toString())) {
				value = 0;
			}
			if (arg.equals(Instructions.TRUE.toString())) {
				value = 1;
			}
			return value;
		}
		arg = instruction.substring(instruction.lastIndexOf(' ') + 1);
		return Integer.parseInt(arg);
	}

	private String getPrintArg() {
		String arg = new String();
		if (currInstruction.contains(InputParser.QUOTATION)) {
			arg = currInstruction.split(InputParser.QUOTATION)[1];
			return arg;
		}
		if (isArgVariable(currInstruction)) {
			return getVariableArg(currInstruction);
		}
		return new Integer(getValueArg(currInstruction)).toString();
	}

	private void constructDeclareNode(ASTNode parrent, String var) {
		DeclareNode declareNode = new DeclareNode(parrent);
		parrent.addChild(declareNode);
		LvalNode lvalNode = new LvalNode(declareNode, var);
		declareNode.addChild(lvalNode);
		currInstruction = inputParser.getInstruction();
		constructConstantNode(declareNode);
	}

	private void constructPrintNode(ASTNode parrent, String arg,
			boolean isVariable) {
		PrintNode printNode = new PrintNode(parrent);
		parrent.addChild(printNode);
		if (isVariable) {
			VariableNode varNode = new VariableNode(printNode, arg);
			printNode.addChild(varNode);
			return;
		}
		StringNode strNode = new StringNode(printNode, arg);
		printNode.addChild(strNode);
	}

	private void constructConstantNode(ASTNode parrent) {
		ConstantNode constantNode = new ConstantNode(parrent,
				getValueArg(currInstruction));
		parrent.addChild(constantNode);
	}

	private void constructIfNode(ASTNode parrent, String var) {
		IfNode ifNode = new IfNode(parrent);
		parrent.addChild(ifNode);
		ConditionNode condNode = new ConditionNode(ifNode, var);
		ifNode.addChild(condNode);
		IfBodyNode ifBody = new IfBodyNode(ifNode);
		ifNode.addChild(ifBody);
		constructIfBodyNode(ifBody);

		if (currInstruction.equals(Instructions.ELSE.toString())) {
			ElseBodyNode elseBodyNode = new ElseBodyNode(ifNode);
			ifNode.addChild(elseBodyNode);
			while (!currInstruction.equals(Instructions.END_IF.toString())) {
				currInstruction = inputParser.getInstruction();
				chooseInstruction(elseBodyNode);
			}
		}
	}

	private void constructWhileNode(ASTNode parrent, String var) {
		WhileNode whileNode = new WhileNode(parrent);
		parrent.addChild(whileNode);
		ConditionNode condNode = new ConditionNode(whileNode, var);
		whileNode.addChild(condNode);
		BodyNode bodyNode = new BodyNode(whileNode);
		whileNode.addChild(bodyNode);
		constructBodyNode(bodyNode);
	}

	private void constructIfBodyNode(ASTNode parrent) {
		currInstruction = inputParser.getInstruction();
		while (!currInstruction.equals(Instructions.END_IF.toString())
				&& !currInstruction.equals(Instructions.ELSE.toString())) {
			chooseInstruction(parrent);
			currInstruction = inputParser.getInstruction();
		}
	}

	private void constructBodyNode(ASTNode parrent) {
		currInstruction = inputParser.getInstruction();
		while (!currInstruction.equals(Instructions.END_WHILE.toString())) {
			chooseInstruction(parrent);
			currInstruction = inputParser.getInstruction();
		}
	}

	private boolean isArgVariable(String instruction) {
		if (currInstruction.contains(InputParser.QUOTATION)
				|| Character.isDigit(currInstruction
						.substring(currInstruction.lastIndexOf(' ') + 1)
						.charAt(0))
				|| currInstruction.contains("@")) {
			return false;
		}
		return true;
	}

	private ASTNode chooseOperation(ASTNode parrent) {
		ASTNode node;
		if (isArgVariable(currInstruction)) {
			node = new RvalNode(parrent, getVariableArg(currInstruction));
		} else {
			node = new ConstantNode(parrent, getValueArg(currInstruction));
		}
		if (currInstruction.startsWith(Instructions.SET_VALUE.toString())) {
			return node;
		}
		if (currInstruction.startsWith(Instructions.AND.toString())) {
			AndNode andNode = new AndNode(parrent);
			andNode.addChild(node);
			return andNode;
		}
		if (currInstruction
				.startsWith(Instructions.MINUS_OPERATOR.toString())) {
			DifferenceNode diffNode = new DifferenceNode(parrent);
			diffNode.addChild(node);
			return diffNode;
		}
		if (currInstruction
				.startsWith(Instructions.DIVISION_OPERATOR.toString())) {
			DivisionNode divNode = new DivisionNode(parrent);
			divNode.addChild(node);
			return divNode;
		}
		if (currInstruction.startsWith(Instructions.EQUAL_TO.toString())) {
			EqualToNode equalNode = new EqualToNode(parrent);
			equalNode.addChild(node);
			return equalNode;
		}
		if (currInstruction.startsWith(Instructions.GREATER_THAN.toString())) {
			GreaterThanNode grtNode = new GreaterThanNode(parrent);
			grtNode.addChild(node);
			return grtNode;
		}
		if (currInstruction
				.startsWith(Instructions.MODULO_OPERATOR.toString())) {
			ModuloNode modNode = new ModuloNode(parrent);
			modNode.addChild(node);
			return modNode;
		}
		if (currInstruction
				.startsWith(Instructions.MULTIPLICATION_OPERATOR.toString())) {
			MultiplicationNode mulNode = new MultiplicationNode(parrent);
			mulNode.addChild(node);
			return mulNode;
		}
		if (currInstruction.startsWith(Instructions.OR.toString())) {
			OrNode orNode = new OrNode(parrent);
			orNode.addChild(node);
			return orNode;
		}
		if (currInstruction.startsWith(Instructions.PLUS_OPERATOR.toString())) {
			SumNode sumNode = new SumNode(parrent);
			sumNode.addChild(node);
			return sumNode;
		}
		return null;
	}

	private void constructAssigmentNode(ASTNode parrent, String var) {
		AssignmentNode assNode = new AssignmentNode(parrent);
		parrent.addChild(assNode);
		LvalNode lvalNode = new LvalNode(parrent, var);
		assNode.addChild(lvalNode);

		ArrayList<ASTNode> nodes = new ArrayList<ASTNode>();
		currInstruction = inputParser.getInstruction();
		while (!currInstruction
				.equals(Instructions.END_ASSIGN_VARIABLE.toString())) {
			nodes.add(chooseOperation(assNode));
			currInstruction = inputParser.getInstruction();
		}

		for (int i = 0; i < nodes.size() - 1; i++) {
			nodes.get(i).setParrent(nodes.get(i + 1));
			nodes.get(i + 1).addChildAtFront(nodes.get(i));
		}
		nodes.get(nodes.size() - 1).setParrent(assNode);
		assNode.addChild(nodes.get(nodes.size() - 1));
	}

	private void chooseInstruction(ASTNode parrent) {
		if (currInstruction.startsWith(Instructions.DECLARE_INT.toString())) {
			constructDeclareNode(parrent, getVariableArg(currInstruction));
			return;
		}
		if (currInstruction.startsWith(Instructions.PRINT.toString())) {
			String arg = getPrintArg();
			boolean isVar = isArgVariable(currInstruction);
			constructPrintNode(parrent, arg, isVar);
			return;
		}
		if (currInstruction.startsWith(Instructions.IF.toString())) {
			constructIfNode(parrent, getVariableArg(currInstruction));
			return;
		}
		if (currInstruction.startsWith(Instructions.WHILE.toString())) {
			constructWhileNode(parrent, getVariableArg(currInstruction));
			return;
		}
		if (currInstruction
				.startsWith(Instructions.ASSIGN_VARIABLE.toString())) {
			constructAssigmentNode(parrent, getVariableArg(currInstruction));
			return;
		}
	}
}