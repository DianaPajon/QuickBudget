package com.aura.quickbudget.backend.service.endpoint.operationdto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public class MovementDTO implements Serializable {
	
	private static final long serialVersionUID = 2517501410522294857L;
	
	private BigDecimal value;
	private Date date;
	private Set<String> relatedIncomeIds;
	private Set<String> relatedExpenseIds;
	
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public Set<String> getRelatedIncomeIds() {
		return relatedIncomeIds;
	}
	public void setRelatedIncomeIds(Set<String> relatedIncomeIds) {
		this.relatedIncomeIds = relatedIncomeIds;
	}
	public Set<String> getRelatedExpenseIds() {
		return relatedExpenseIds;
	}
	public void setRelatedExpenseIds(Set<String> relatedExpenseIds) {
		this.relatedExpenseIds = relatedExpenseIds;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
