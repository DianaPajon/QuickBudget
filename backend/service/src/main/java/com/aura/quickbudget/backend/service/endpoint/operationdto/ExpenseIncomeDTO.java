package com.aura.quickbudget.backend.service.endpoint.operationdto;

import java.io.Serializable;

public class ExpenseIncomeDTO implements Serializable {

	private static final long serialVersionUID = 3993687242521421380L;

	private String eeid;
	private String name;
	private String amount;
	private boolean periodic;
	private TimePeriodDTO period;
	private Integer installments;
	
	
	public String getEeid() {
		return eeid;
	}

	public void setEeid(String eeid) {
		this.eeid = eeid;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	public boolean isPeriodic() {
		return periodic;
	}

	public void setPeriodic(boolean periodic) {
		this.periodic = periodic;
	}

	public TimePeriodDTO getPeriod() {
		return period;
	}
	
	public void setPeriod(TimePeriodDTO period) {
		this.period = period;
	}
	
	public Integer getInstallments() {
		return installments;
	}
	
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
}
