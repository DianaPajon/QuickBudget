package com.aura.quickbudget.backend.model.service.interf.accountsync;

import java.util.List;
import java.util.Set;

import com.aura.quickbudget.backend.model.service.dto.ExpenseIncomeDTO;
import com.aura.quickbudget.backend.model.service.dto.MovementDTO;

public class AccountRequestInterf {
	
	private String accountName;
	private List<MovementDTO> movements;
	private Set<ExpenseIncomeDTO> expenses;
	private Set<ExpenseIncomeDTO> incomes;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public List<MovementDTO> getMovements() {
		return movements;
	}
	public void setMovements(List<MovementDTO> movements) {
		this.movements = movements;
	}
	public Set<ExpenseIncomeDTO> getExpenses() {
		return expenses;
	}
	public void setExpenses(Set<ExpenseIncomeDTO> expenses) {
		this.expenses = expenses;
	}
	public Set<ExpenseIncomeDTO> getIncomes() {
		return incomes;
	}
	public void setIncomes(Set<ExpenseIncomeDTO> incomes) {
		this.incomes = incomes;
	}
	
	  
}
