package fr.sg.cata.sgbank.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOperation;
	
	@ManyToOne
	@JoinColumn(name ="NUM_ACCOUNT")
	private Account account;
	
	@Column(name = "TYPE_OPERATION")
	@Enumerated(EnumType.STRING)
	private OperationType typeOperation;
	
	@Column(name = "DATE_OPERATION")
	private Date dateOperation;
	
	@Column(name = "BALANCE")
	private BigDecimal balance;
	
	public enum OperationType{
		WITHDRAWAL, DEPOSIT;
	}
	
	

	public Operation(Account account, OperationType typeOperation, Date dateOperation, BigDecimal balance) {
		super();
		this.account = account;
		this.typeOperation = typeOperation;
		this.dateOperation = dateOperation;
		this.balance = balance;
	}

	public Integer getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public OperationType getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(OperationType typeOperation) {
		this.typeOperation = typeOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}	
	
}
