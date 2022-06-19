package com.aura.quickbudget.backend.service.repository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.aura.quickbudget.backend.model.entities.Account;
import com.aura.quickbudget.backend.model.entities.ExpenseIncome;
import com.aura.quickbudget.backend.model.entities.Movement;
import com.aura.quickbudget.backend.model.repository.AccountRepository;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;


@Component
public class AccountRepositoryImpl implements  AccountRepository {

	Account only = new Account() {

		List<Movement> movementList = new ArrayList<>();
		Set<ExpenseIncome> expenses = new HashSet<>();
		Set<ExpenseIncome> incomes= new HashSet<>();
		
		@Override
		public String getName() {
			return "aura";
		}

		@Override
		public List<Movement> getMovements() {
			// TODO Auto-generated method stub
			return this.movementList;
		}

		@Override
		public void setMovements(List<Movement> movements) {
			this.movementList = movements;
			
		}

		@Override
		public Set<ExpenseIncome> getIncomes() {
			// TODO Auto-generated method stub
			return this.incomes;
		}

		@Override
		public void setIncomes(Set<ExpenseIncome> incomes) {
			this.incomes = incomes;
			
		}

		@Override
		public Set<ExpenseIncome> getExpenses() {
			return this.expenses;
		}

		@Override
		public void setExpenses(Set<ExpenseIncome> expenses) {
			this.expenses = expenses;
		}
		
	};
	
	@Override
	public Account getAccount(String accountId) throws AccountThrowableNotFound{
		if(Objects.equals(this.only.getName(), accountId)) {
			return only;
		} else { 
			throw new AccountThrowableNotFound(accountId);
		}
	}

	
	@Override
	public void updateAccount(Account account) throws AccountThrowableNotFound, AccountThrowableMovementsNotConsecutive {
		if(Objects.equals(account.getName(), only.getName())){
			this.only = account;
		} else {
			throw new AccountThrowableNotFound(account.getName());
		}
	}

}
