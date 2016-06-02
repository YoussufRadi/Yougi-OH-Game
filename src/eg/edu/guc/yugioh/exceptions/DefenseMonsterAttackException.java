package eg.edu.guc.yugioh.exceptions;

public class DefenseMonsterAttackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DefenseMonsterAttackException() {
			super("The monster is in defense, you cannot attack.");
	}
}
