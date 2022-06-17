package com.aura.quickbudget.backend.model.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.quickbudget.backend.model.api.Account;


public interface Movement {
	public BigDecimal getValue();
	public String getMovementId();
	public Date getDate();
	public Set<String> getRelatedIncomes();
	public Set<String> getRelatedExpenses();
}
