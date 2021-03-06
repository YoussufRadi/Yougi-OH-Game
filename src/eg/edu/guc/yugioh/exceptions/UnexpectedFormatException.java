package eg.edu.guc.yugioh.exceptions;

abstract public class UnexpectedFormatException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sourceFile;
	private int sourceLine;
	
	public UnexpectedFormatException(String sourceFile,int sourceLine) {
		super("The File " +sourceFile+ " has in an error in the line " +sourceLine);
		this.sourceFile = sourceFile;
		this.sourceLine = sourceLine;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	public int getSourceLine() {
		return sourceLine;
	}

	public void setSourceLine(int sourceLine) {
		this.sourceLine = sourceLine;
	}
	
	
	
}
