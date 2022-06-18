package com.aura.quickbudget.backend.model.api;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;



public class Movement {
	private BigDecimal value;
	private String movementId;
	private Date date;
	private Set<String> relatedIncomes;
	private Set<String> relatedExpenses;
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public String getMovementId() {
		return movementId;
	}
	public void setMovementId(String movementId) {
		this.movementId = movementId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<String> getRelatedIncomes() {
		return relatedIncomes;
	}
	public void setRelatedIncomes(Set<String> relatedIncomes) {
		this.relatedIncomes = relatedIncomes;
	}
	public Set<String> getRelatedExpenses() {
		return relatedExpenses;
	}
	public void setRelatedExpenses(Set<String> relatedExpenses) {
		this.relatedExpenses = relatedExpenses;
	}
	
	
	
	
}
