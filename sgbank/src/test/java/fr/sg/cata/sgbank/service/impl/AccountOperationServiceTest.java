package fr.sg.cata.sgbank.service.impl;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import fr.sg.cata.sgbank.dao.AccountDao;
import fr.sg.cata.sgbank.entities.Account;
import fr.sg.cata.sgbank.exception.InsufficientAmountException;
import junit.framework.Assert;

public class AccountOperationServiceTest {

	Account account;
	AccountOperationImpl service;
	
	@Mock
	AccountDao accountDaoMock;
	
	@Before
	public void setup() {
		account = new Account(120, new BigDecimal("1000"));
		service = new AccountOperationImpl();
		when(accountDaoMock.findByCode(120)).thenReturn(account);
	}	
	
	@Test
	public void shouldChangeSoldeWhenDeposeMoney(){
		service.deposeMoney(new BigDecimal(1000), "120");
		Assert.assertEquals(new BigDecimal(2000), account.getSolde());
		
	}
	
	@Test(expected = InsufficientAmountException.class)
	public void shouldThrowExceptionWhenWithdrawMoney() throws InsufficientAmountException {	
		assertTrue(service.withdrawMoney(new BigDecimal(100), "120"));
		service.withdrawMoney(new BigDecimal(100000), "120");
	}
	
	@Test
	public void shouldReturnEmptyOperationsWhenErrorAccount() {
		assertTrue(service.checkOperations("120").isEmpty());
	}	
}
