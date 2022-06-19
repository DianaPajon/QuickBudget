package com.aura.quickbudget.backend.model.service.dto.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.aura.quickbudget.backend.model.entities.ExpenseIncome;
import com.aura.quickbudget.backend.model.entities.TimePeriod;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidExpenseIncome;

public class ExpenseIncomeDTO implements Serializable {

	private static final long serialVersionUID = 3993687242521421380L;

	private String eeid;
	private String name;
	private BigDecimal amount;
	private boolean periodic;
	private TimePeriod period;
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
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
	public boolean isPeriodic() {
		return periodic;
	}

	public void setPeriodic(boolean periodic) {
		this.periodic = periodic;
	}

	public TimePeriod getPeriod() {
		return period;
	}
	
	public void setPeriod(TimePeriod  period) {
		this.period = period;
	}
	
	public Integer getInstallments() {
		return installments;
	}
	
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
	public  static ExpenseIncomeDTO buildFromModel(ExpenseIncome e) {
		
		ExpenseIncomeDTO dto = new ExpenseIncomeDTO();
		dto.setName(e.getName());
		dto.setEeid(e.getEeid());
		dto.setInstallments(e.getInstallments());
		dto.setName(e.getName());
		if(e.getPeriod() != null) {
			dto.setPeriod(new TimePeriod(
					dto.getPeriod().getDays(), 
					dto.getPeriod().getMonths(), 
					dto.getPeriod().getYears())
			);	
		}
		dto.setPeriodic(e.isPeriodic());
		return dto;
	}
	
	public static void fillWithData(ExpenseIncomeDTO dto, ExpenseIncome e) throws AccountThrowableInvalidExpenseIncome  {
		if(dto.getAmount() == null)
			throw new AccountThrowableInvalidExpenseIncome();
		if(dto.getEeid() == null)
			throw new AccountThrowableInvalidExpenseIncome();
		if(dto.isPeriodic() && dto.getPeriod() == null)
			throw new AccountThrowableInvalidExpenseIncome();
		//TODO:fill this
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getEeid());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpenseIncomeDTO other = (ExpenseIncomeDTO) obj;
		return Objects.equals(this.getEeid(), other.getEeid());
	}
	
}
