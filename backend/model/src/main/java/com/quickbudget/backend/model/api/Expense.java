package com.quickbudget.backend.model.api;

import java.math.BigDecimal;

public interface Expense {
	public String name();
	public Boolean isPeriodic();
	public TimePeriod getPeriod();
}
