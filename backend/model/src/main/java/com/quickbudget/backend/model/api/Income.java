package com.quickbudget.backend.model.api;

import java.math.BigDecimal;


public interface Income {
	public BigDecimal getAmount();
	public boolean isPeriodic();
	public TimePeriod getPeriod();
}
