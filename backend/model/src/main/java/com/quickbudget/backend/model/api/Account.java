package com.quickbudget.backend.model.api;

import java.util.Date;
import java.util.List;

public interface Account {
	public String getName();
	public List<Movement> getCurrentMovements();
	public List<Movement> getMovementsToDate(Date date);
	public List<Expense> getAssociatedExpenses();
	public List<Income> getAssociatedIncomes();
}