package com.aura.quickbudget.backend.model.api;

import java.util.List;
import java.util.Set;

public interface Account {
	public String getName();
	
	public List<Movement> getMovements();
	public void setMovements(List<Movement> movements);
	public Set<ExpenseIncome> getIncomes();
	public void setIncomes(Set<ExpenseIncome> incomes);
	public Set<ExpenseIncome> getExpenses();
	public void setExpenses(Set<ExpenseIncome> expenses);	
}
