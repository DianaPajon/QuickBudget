package com.aura.quickbudget.backend.model.service.interf.accountsync;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.aura.quickbudget.backend.model.service.dto.ExpenseIncomeDTO;
import com.aura.quickbudget.backend.model.service.dto.MovementDTO;

public class UpdateAccountInterf implements Serializable {

	private static final long serialVersionUID = 4256793324488769965L;
	
	private String accountName;
	private List<MovementDTO> newMovements;
	private Set<ExpenseIncomeDTO> newExpenses;
	private Set<ExpenseIncomeDTO> newIncomes;
	
	
	public UpdateAccountInterf() {}
	
	public UpdateAccountInterf(String accountName, List<MovementDTO> newMovements, Set<ExpenseIncomeDTO> newExpenses,
			Set<ExpenseIncomeDTO> newIncomes) {
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
	
	public Set<ExpenseIncomeDTO> getNewExpenses() {
		return newExpenses;
	}
	
	public void setNewExpenses(Set<ExpenseIncomeDTO> newExpenses) {
		this.newExpenses = newExpenses;
	}
	
	public Set<ExpenseIncomeDTO> getNewIncomes() {
		return newIncomes;
	}
	
	public void setNewIncomes(Set<ExpenseIncomeDTO> newIncomes) {
		this.newIncomes = newIncomes;
	}
	
	
}
