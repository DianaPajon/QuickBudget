package com.aura.quickbudget.backend.model.api;

import java.math.BigDecimal;
import java.sql.Date;

import com.quickbudget.backend.model.api.TimePeriod;


public interface ExpenseIncome {
	public String getEeid();
	public String getName();
	public BigDecimal getAmount();
	public Date getInitialDate();
	public boolean isPeriodic();
	public TimePeriod getPeriod();
	public Integer getInstallments();
}
