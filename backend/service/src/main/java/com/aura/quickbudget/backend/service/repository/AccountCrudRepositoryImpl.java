package com.aura.quickbudget.backend.service.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;

import com.quickbudget.backend.model.api.Account;
import com.quickbudget.backend.model.api.Expense;
import com.quickbudget.backend.model.api.Income;
import com.quickbudget.backend.model.api.Movement;
import com.quickbudget.backend.model.api.repository.AccountCrudRepository;
import com.quickbudget.backend.model.api.repository.exception.ObjectNotFoundException;

@Component
public class AccountCrudRepositoryImpl implements  AccountCrudRepository {

	Account only = new Account() {

		@Override
		public String getName() {
			return "aura";
		}

		@Override
		public List<Movement> getCurrentMovements() {
			return new ArrayList<>();
		}

		@Override
		public List<Movement> getMovementsToDate(Date date) {
			return new ArrayList<>();
		}

		@Override
		public List<Expense> getAssociatedExpenses() {
			return new ArrayList<>();
		}

		@Override
		public List<Income> getAssociatedIncomes() {
			return new ArrayList<>();
		}

		
	};
	
	@Override
	public Account getAccount(String accountId) throws ObjectNotFoundException{
		if(Objects.equals(this.only.getName(), accountId)) {
			return only;
		} else { 
			throw new ObjectNotFoundException(null, Account.class);
		}
	}

}
