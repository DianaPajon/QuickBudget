package com.aura.quickbudget.backend.model.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;



public interface Movement {
	public BigDecimal getValue();
	public String getMovementId();
	public Date getDate();
	public Set<String> getRelatedIncomes();
	public Set<String> getRelatedExpenses();
	
	
}
