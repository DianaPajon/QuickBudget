package com.aura.quickbudget.backend.model.entities;

public class TimePeriod {
	private Integer days;
	private Integer months;
	private Integer years;
	
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Integer getMonths() {
		return months;
	}
	public void setMonths(Integer months) {
		this.months = months;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	
	public TimePeriod() {}
	
	public TimePeriod(Integer days, Integer months, Integer years) {
		super();
		this.days = days;
		this.months = months;
		this.years = years;
	}
	
	
}
