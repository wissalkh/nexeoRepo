package fr.sg.cata.sgbank.exception;

public class InsufficientAmountException extends Exception{

	private static final long serialVersionUID = 7944573383550548967L;
	
	public InsufficientAmountException(String errorMessage) {
		super(errorMessage);
	}

}
