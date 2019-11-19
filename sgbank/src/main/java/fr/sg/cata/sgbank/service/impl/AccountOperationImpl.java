package fr.sg.cata.sgbank.service.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sg.cata.sgbank.dao.AccountDao;
import fr.sg.cata.sgbank.entities.Account;
import fr.sg.cata.sgbank.entities.Operation;
import fr.sg.cata.sgbank.entities.Operation.OperationType;
import fr.sg.cata.sgbank.service.AccountOperationService;

@Service
public class AccountOperationImpl implements AccountOperationService{

	private static Logger LOGGER = Logger.getLogger(AccountOperationImpl.class);
	
	@Autowired
	private AccountDao accountDAO;	

	public void deposeMoney(BigDecimal amount, Account account) {
		account.getSolde().add(amount);
		Calendar calendar = Calendar.getInstance();
		account.addOperation(new Operation(account, OperationType.DEPOSIT, calendar.getTime()));
		accountDAO.update(account);
		LOGGER.info("The deposit of " + amount +" is succefully done. your actual solde is: "+ account.getSolde());
	}

	public Boolean withdrawMoney(BigDecimal amount, Account account) {
		if(account.getSolde().compareTo(amount) >= 0) {
			account.getSolde().subtract(amount);
			account.addOperation(new Operation(account, OperationType.WITHDRAWAL, Calendar.getInstance().getTime()));
			accountDAO.update(account);
			LOGGER.info("You can take your money please! your actual solde is: "+ account.getSolde());
			return true;
		}else {
			LOGGER.info("You don't have enough money!");
			return false;
		}
	}

	public List<Operation> checkOperations(Account account) {
		return account.getOperations();
	}

	public Account findAccountByCode(int code) {
		return accountDAO.findByCode(code);
	}

	public void persist(Account account) {
		accountDAO.persist(account);		
	}

}
