package ro.poo.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import ro.poo.Instructions;

/**
 * Class for reading the input and removing the additional spaces and lines
 * 
 * @author Alexandru Lincan
 *
 */
public class InputParser {
	private BufferedReader buffReader;
	public static final String QUOTATION = "\"";

	/**
	 * Separates a instruction from its argument if it exists
	 * 
	 * @param instruction
	 * @return the instruction without argument
	 */
	public String getNoArgInstruction(String instruction) {
		String noArg = new String();
		if (instruction.lastIndexOf(' ') != -1) {
			noArg = instruction.substring(0, instruction.lastIndexOf(' '));
		}
		if (instruction.startsWith(Instructions.PRINT.toString())) {
			if (instruction.indexOf(QUOTATION) != -1) {
				noArg = instruction.substring(0,
						instruction.indexOf(QUOTATION) - 1);
			}
		}
		if (instruction.indexOf('@') != -1) {
			noArg = instruction.substring(0, instruction.indexOf('@') - 1);
		}

		return noArg;
	}

	private boolean isInstructionValid(String instruction) {
		String noArg = getNoArgInstruction(instruction);
		if (ASTBuilder.instructionsSet.containsKey(instruction)
				|| ASTBuilder.instructionsSet.containsKey(noArg)) {
			return true;
		}
		return false;
	}

	/**
	 * Instantiates a BufferedReader for the specified inputFile
	 * 
	 * @param inputFile
	 *            the input file to read
	 */
	public InputParser(String inputFile) {
		try {
			buffReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the next valid instruction without extra spaces
	 * 
	 * @return the instruction as a String
	 */
	public String getInstruction() {
		String line = null;
		try {
			if (!buffReader.ready()) {
				return null;
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			line = buffReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] parts = line.split(QUOTATION);
		String instruction = new String();

		StringTokenizer st = new StringTokenizer(parts[0]);
		while (st.hasMoreTokens()) {
			instruction += st.nextToken();
			if (st.hasMoreTokens()) {
				instruction += ' ';
			}
		}
		if (parts.length > 1) {
			instruction += " " + line.substring(line.indexOf(QUOTATION));
		}

		if (!isInstructionValid(instruction)) {
			return getInstruction();
		}
		return instruction;
	}
}