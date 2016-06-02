package eg.edu.guc.yugioh.exceptions;

public class EmptyFieldException extends UnexpectedFormatException {

	/**
	 * 
	 */
	private int sourceField;
	private static final long serialVersionUID = 1L;

	public EmptyFieldException(String sourceFile, int sourceLine, int sourceField) {
		super(sourceFile, sourceLine);
		this.sourceField = sourceField;
	}

	public int getSourceField() {
		return sourceField;
	}

	public void setSourceField(int sourceField) {
		this.sourceField = sourceField;
	}
	
}
