package ro.poo;

import ro.poo.ast.nodes.MainNode;
import ro.poo.ast.operations.InterpreterVisitor;
import ro.poo.ast.operations.PrintVisitor;
import ro.poo.input.ASTBuilder;

/**
 * A simple ArnoldC Interpreter
 * 
 * @author Alexandru Lincan
 *
 */
public class Interpreter {
	private MainNode mainNode;

	/**
	 * Interprets a file with ArnoldC code
	 * 
	 * @param inputFile
	 */
	public void interpretFile(String inputFile, String outFile,
			String astFile) {
		ASTBuilder builder = new ASTBuilder(inputFile);
		mainNode = builder.constructAST();
		PrintVisitor printVisitor = new PrintVisitor(astFile);
		mainNode.accept(printVisitor);
		InterpreterVisitor interpretVisitor = new InterpreterVisitor(outFile);
		mainNode.accept(interpretVisitor);
	}

	public static void main(String[] args) {
		Interpreter interpreter = new Interpreter();
		interpreter.interpretFile(args[0], args[1], args[2]);
	}
}