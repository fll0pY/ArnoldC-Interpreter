package ro.poo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class for printing the output in a file
 * 
 * @author fll0pY
 *
 */
public class OutputWriter {
	private PrintWriter writer;

	public OutputWriter(String outputFile) {
		try {
			writer = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints an array of int to file
	 * 
	 * @param toPrint
	 *            the integers to be printed
	 */
	public void print(int[] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			writer.print(toPrint[i]);
			if (i != toPrint.length - 1) {
				writer.print(" ");
			}
		}
		writer.println();
	}

	/**
	 * Prints a text to file
	 * 
	 * @param text
	 *            the text to be printed
	 */
	public void print(String text) {
		writer.print(text);
	}

	/**
	 * Prints a text to file with a newline after
	 * 
	 * @param text
	 *            the text to be printed
	 */
	public void printLine(String text) {
		writer.println(text);
	}

	/**
	 * Close the writing stream
	 */
	public void closeWriter() {
		writer.close();
	}
}