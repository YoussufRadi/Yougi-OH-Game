package eg.edu.guc.yugioh.exceptions;

public class UnknownCardTypeException extends UnexpectedFormatException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String unknownType;

	public UnknownCardTypeException(String sourceFile, int sourceLine, String unknownType) {
		super(sourceFile, sourceLine);
		this.unknownType = unknownType;
	}

	public String getUnknownType() {
		return unknownType;
	}

	public void setUnknownType(String unknownType) {
		this.unknownType = unknownType;
	}
}
