package fr.sg.cata.sgbank.service;

import java.math.BigDecimal;
import java.util.List;

import fr.sg.cata.sgbank.entities.Account;
import fr.sg.cata.sgbank.entities.Operation;
import fr.sg.cata.sgbank.exception.InsufficientAmountException;

public interface AccountOperationFacade {
	
	/**
	 * This method allows a bank client to make a deposit in his account.
	 * @param amount
	 * @param account
	 */
	void deposeMoney(BigDecimal amount, String accountNum);

	/**
	 * This method allows a bank client to withdraw money from his account.
	 * @param amount
	 * @param account
	 * @return
	 * @throws InsufficientAmountException 
	 */
	Boolean withdrawMoney(BigDecimal amount, String accountNum) throws InsufficientAmountException;
	
	/**
	 * This method allows a bank client to check the history of his account.
	 * @param account
	 * @return
	 */
	List<Operation> checkOperations(String accountNum);
}
