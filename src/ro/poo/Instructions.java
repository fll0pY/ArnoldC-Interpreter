/**
 * 
 */
package ro.poo;

/**
 * @author Alexandru Lincan
 *
 */
public enum Instructions {
	FALSE("I LIED"),
	TRUE("NO PROBLEMO"),
	IF("BECAUSE I'M GOING TO SAY PLEASE"),
	ELSE("BULLSHIT"),
	END_IF("YOU HAVE NO RESPECT FOR LOGIC"),
	WHILE("STICK AROUND"),
	END_WHILE("CHILL"),
	PLUS_OPERATOR("GET UP"),
	MINUS_OPERATOR("GET DOWN"),
	MULTIPLICATION_OPERATOR("YOU'RE FIRED"),
	DIVISION_OPERATOR("HE HAD TO SPLIT"),
	MODULO_OPERATOR("I LET HIM GO"),
	EQUAL_TO("YOU ARE NOT YOU YOU ARE ME"),
	GREATER_THAN("LET OFF SOME STEAM BENNET"),
	OR("CONSIDER THAT A DIVORCE"),
	AND("KNOCK KNOCK"),
	DECLARE_INT("HEY CHRISTMAS TREE"),
	SET_INITIAL_VALUE("YOU SET US UP"),
	BEGIN_MAIN("IT'S SHOWTIME"),
	END_MAIN("YOU HAVE BEEN TERMINATED"),
	PRINT("TALK TO THE HAND"),
	ASSIGN_VARIABLE("GET TO THE CHOPPER"),
	SET_VALUE("HERE IS MY INVITATION"),
	END_ASSIGN_VARIABLE("ENOUGH TALK");

	private final String text;

	/**
	 * @param text
	 */
	private Instructions(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}