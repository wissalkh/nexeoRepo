package fr.sg.cata.sgbank.service;

import java.math.BigDecimal;
import java.util.List;

import fr.sg.cata.sgbank.entities.Account;
import fr.sg.cata.sgbank.entities.Operation;

public interface AccountOperationService {
	
	/**
	 * This method returns the account whose identifier is {@value code}
	 * @param code
	 * @return
	 */
	Account findAccountByCode(int code);
	
    /**
     * This method allows the account to be persisted and saved to the database
     * @param account
     */
	void persist(Account account);
	
	/**
	 * This method allows a bank client to make a deposit in his account.
	 * @param amount
	 * @param account
	 */
	void deposeMoney(BigDecimal amount, Account account);

	/**
	 * This method allows a bank client to withdraw money from his account.
	 * @param amount
	 * @param account
	 * @return
	 */
	Boolean withdrawMoney(BigDecimal amount, Account account);
	
	/**
	 * This method allows a bank client to check the history of his account.
	 * @param account
	 * @return
	 */
	List<Operation> checkOperations(Account account);
}
