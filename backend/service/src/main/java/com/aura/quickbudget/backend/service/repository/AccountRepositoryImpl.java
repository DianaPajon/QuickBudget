package com.aura.quickbudget.backend.service.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.aura.quickbudget.backend.model.api.ExpenseIncome;
import com.aura.quickbudget.backend.service.repository.api.AccountRepository;
import com.aura.quickbudget.backend.model.api.Account;
import com.aura.quickbudget.backend.model.api.Movement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;


@Component
public class AccountRepositoryImpl implements  AccountRepository {

	Account only = new Account() {

		List<Movement> movementList = new ArrayList<>();
		
		@Override
		public String getName() {
			return "aura";
		}

		@Override
		public List<Movement> getMovements() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setMovements(List<Movement> movements) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Set<ExpenseIncome> getIncomes() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setIncomes(Set<ExpenseIncome> incomes) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Set<ExpenseIncome> getExpenses() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setExpenses(Set<ExpenseIncome> expenses) {
			// TODO Auto-generated method stub
			
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
