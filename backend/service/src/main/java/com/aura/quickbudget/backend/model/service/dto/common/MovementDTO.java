package com.aura.quickbudget.backend.model.service.dto.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.aura.quickbudget.backend.model.entities.Movement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidMovement;

public class MovementDTO implements Serializable {
	
	private static final long serialVersionUID = 2517501410522294857L;
	
	private BigDecimal value;
	private String movementId;
	private Date date;
	private Set<String> relatedIncome;
	private Set<String> relatedExpense;
	
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
	public Set<String> getRelatedIncomes() {
		return relatedIncome;
	}
	public void setRelatedIncomes(Set<String> relatedIncomeIds) {
		this.relatedIncome = relatedIncomeIds;
	}
	public Set<String> getRelatedExpenses() {
		return relatedExpense;
	}
	public void setRelatedExpenses(Set<String> relatedExpenseIds) {
		this.relatedExpense = relatedExpenseIds;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static MovementDTO buildFromModel(Movement m){
		MovementDTO movementDTO = new MovementDTO();
		movementDTO.setDate(m.getDate());
		movementDTO.setRelatedExpenses(m.getRelatedExpenses());
		movementDTO.setRelatedIncomes(m.getRelatedIncomes());
		movementDTO.setValue(m.getValue());
		movementDTO.setMovementId(m.getMovementId());
		return movementDTO;
	}
	
	public static void fillWithData(MovementDTO dto, Movement m)  throws AccountThrowableInvalidMovement {
		if(dto.getDate() == null)
			throw new AccountThrowableInvalidMovement();
		if(dto.getValue() == null)
			throw new AccountThrowableInvalidMovement();
		m.setValue(dto.getValue());
		m.setDate(dto.getDate());
		m.setMovementId(dto.getMovementId());
		m.setRelatedExpenses(m.getRelatedExpenses());
		m.setRelatedIncomes(m.getRelatedIncomes());
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(movementId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovementDTO other = (MovementDTO) obj;
		return Objects.equals(movementId, other.movementId);
	}
	
	
	
	
}
