package com.aura.quickbudget.backend.service.endpoint.operationdto;

import java.util.List;

public class AccountRequestDTO {
	private String accountName;
	private List<MovementDTO> movements;
	private List<ExpenseIncomeDTO> expenses;
	private List<ExpenseIncomeDTO> incomes;
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
	public List<ExpenseIncomeDTO> getExpenses() {
		return expenses;
	}
	public void setExpenses(List<ExpenseIncomeDTO> expenses) {
		this.expenses = expenses;
	}
	public List<ExpenseIncomeDTO> getIncomes() {
		return incomes;
	}
	public void setIncomes(List<ExpenseIncomeDTO> incomes) {
		this.incomes = incomes;
	}
	
	  
}
