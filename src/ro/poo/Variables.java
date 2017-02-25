package ro.poo;

import java.util.HashMap;

/**
 * Singleton for variables
 * 
 * @author Alexandru Lincan
 *
 */
public class Variables {
	private static Variables instance = null;
	private HashMap<String, Integer> variablesMap;

	protected Variables() {
		variablesMap = new HashMap<String, Integer>();
	}

	public static Variables getInstance() {
		if (instance == null) {
			instance = new Variables();
		}
		return instance;
	}

	/**
	 * @return the variablesMap
	 */
	public HashMap<String, Integer> getVariablesMap() {
		return variablesMap;
	}

	/**
	 * @param variablesMap
	 *            the variablesMap to set
	 */
	public void setVariablesMap(HashMap<String, Integer> variablesMap) {
		this.variablesMap = variablesMap;
	}
}