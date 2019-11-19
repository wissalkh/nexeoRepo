package fr.sg.cata.sgbank.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@Column(name = "NUM_ACCOUNT")
	private int numAccount;
	
	@Column(name = "SOLDE")
	private BigDecimal solde;		
	
	@OneToMany(mappedBy = "account")
	private List<Operation> operations = new ArrayList<Operation>();

	
	public Account(int numAccount, BigDecimal solde) {
		super();
		this.numAccount = numAccount;
		this.solde = solde;
	}
	
	public BigDecimal getSolde() {
		return solde;
	}
	
	public void setSolde(BigDecimal solde) {
		this.solde = solde;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	public void addOperation(Operation operation) {
		this.operations.add(operation);
	}

	public int getNumAccount() {
		return numAccount;
	}

	public void setNumAccount(int numAccount) {
		this.numAccount = numAccount;
	}

	@Override
	public String toString() {
		return "Account [numAccount=" + numAccount + ", solde=" + solde + ", operations=" + operations + "]";
	}	
	
}
