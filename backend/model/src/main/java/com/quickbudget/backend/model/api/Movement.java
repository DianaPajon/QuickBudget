package com.quickbudget.backend.model.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface Movement {
	public BigDecimal getValue();
	public Date getDate();
	public Account getAccount();
	public List<Income> getRelatedIncomes();
	public List<Expense> getRelatedExpenses();
}
