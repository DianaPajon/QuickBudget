package com.aura.quickbudget.backend.service.endpoint.operationdto;

import java.io.Serializable;
import java.util.List;

public class UpdateAccountDTO implements Serializable {

	private static final long serialVersionUID = 4256793324488769965L;
	
	private String accountName;
	private List<MovementDTO> newMovements;
	private List<ExpenseIncomeDTO> newExpenses;
	private List<ExpenseIncomeDTO> newIncomes;
	
	
	public UpdateAccountDTO(String accountName, List<MovementDTO> newMovements, List<ExpenseIncomeDTO> newExpenses,
			List<ExpenseIncomeDTO> newIncomes) {
		this.accountName = accountName;
		this.newMovements = newMovements;
		this.newExpenses = newExpenses;
		this.newIncomes = newIncomes;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public List<MovementDTO> getNewMovements() {
		return newMovements;
	}
	
	public void setNewMovements(List<MovementDTO> newMovements) {
		this.newMovements = newMovements;
	}
	
	public List<ExpenseIncomeDTO> getNewExpenses() {
		return newExpenses;
	}
	
	public void setNewExpenses(List<ExpenseIncomeDTO> newExpenses) {
		this.newExpenses = newExpenses;
	}
	
	public List<ExpenseIncomeDTO> getNewIncomes() {
		return newIncomes;
	}
	
	public void setNewIncomes(List<ExpenseIncomeDTO> newIncomes) {
		this.newIncomes = newIncomes;
	}
	
	
}
