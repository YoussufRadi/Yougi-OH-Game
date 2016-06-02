package eg.edu.guc.yugioh.exceptions;

public class NoSpellSpaceException extends NoSpaceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSpellSpaceException() {
		super("The spell field is already full.");
	}

}
