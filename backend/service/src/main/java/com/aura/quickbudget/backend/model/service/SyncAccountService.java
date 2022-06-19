package com.aura.quickbudget.backend.model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.aura.quickbudget.backend.model.entities.Account;
import com.aura.quickbudget.backend.model.entities.ExpenseIncome;
import com.aura.quickbudget.backend.model.entities.Movement;
import com.aura.quickbudget.backend.model.repository.AccountRepository;
import com.aura.quickbudget.backend.model.service.authorizer.SyncAccountAuthorizer.GetAccountToken;
import com.aura.quickbudget.backend.model.service.authorizer.SyncAccountAuthorizer.SyncAccountToken;
import com.aura.quickbudget.backend.model.service.dto.common.ExpenseIncomeDTO;
import com.aura.quickbudget.backend.model.service.dto.common.MovementDTO;
import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidExpenseIncome;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidMovement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

public interface SyncAccountService {
	
	public default AccountRequestDTO getAccount(String accountName, GetAccountToken token) 
			throws 
				AccountThrowableNotFound,
				UnauthorizedException
	{
		if(token == null) {
			throw new UnauthorizedException();
		}
		//I fetch the account,  will throw exception here if not found, it is expected.
		Account requested = this.getAccountRepository().getAccount(accountName);
		AccountRequestDTO ret = new AccountRequestDTO();
		ret.setAccountName(requested.getName());
	
		List<Movement> movements = requested.getMovements();
		ret.setMovements(movements.stream().map(MovementDTO::buildFromModel).collect(Collectors.toList()));	

		Set<ExpenseIncome> expenses = requested.getExpenses();
		ret.setExpenses(expenses.stream().map(ExpenseIncomeDTO::buildFromModel).collect(Collectors.toSet()));
		
		Set<ExpenseIncome> incomes = requested.getExpenses();
		ret.setIncomes(incomes .stream().map(ExpenseIncomeDTO::buildFromModel).collect(Collectors.toSet()));
		
		return ret;
	}
	
	public default void updateAccount(UpdateAccountDTO updateDTO, SyncAccountToken token) 
			throws 			
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableNotFound, 
				AccountThrowableInvalidMovement, 
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableInvalidExpenseIncome,
				UnauthorizedException
	{
		if(token == null) {
			throw new UnauthorizedException();
		}
		Account toUpdate = this.getAccountRepository().getAccount(updateDTO.getAccountName());
		
		//First i check that movements are valid and I update them.
		if(
				updateDTO.getNewMovements() != null &&
				updateDTO.getNewMovements().size() > 0) 
		{
			Comparator<Movement> dateComparator = new Comparator<Movement>() {

				@Override
				public int compare(Movement arg0, Movement arg1) {
					return arg0.getDate().compareTo(arg1.getDate());
				}
				
			};

			if(toUpdate.getMovements() == null) {
				toUpdate.setMovements(new ArrayList<Movement>());
			}
			if(toUpdate.getMovements().size() != 0) {
				Date lastMovementDate = toUpdate.getMovements().stream().max(dateComparator).get().getDate();
				Comparator<MovementDTO> reverseDateComparator = new Comparator<MovementDTO>() {

					@Override
					public int compare(MovementDTO arg0, MovementDTO arg1) {
						return arg1.getDate().compareTo(arg0.getDate());
					}
					
				};
				Date firstDtoMovementDate = updateDTO.getNewMovements().stream().max(reverseDateComparator).get().getDate();
				if(!lastMovementDate.before(firstDtoMovementDate)) {
					throw new AccountThrowableMovementsNotConsecutive();
				}
			}
			
			try {
				List<Movement> newMovements = new ArrayList<>();
				for(MovementDTO mDTO : updateDTO.getNewMovements()) {
					Movement m = new Movement();
					MovementDTO.fillWithData(mDTO, m);
					newMovements.add(m);
				}
				Collections.sort(newMovements, dateComparator);
				toUpdate.getMovements().addAll(newMovements);
			} catch( NullPointerException e) {
				throw new AccountThrowableInvalidMovement();
			}
			
		}
		
		//Now, I add the new expenses.
		if(updateDTO.getNewExpenses() != null) {

			Set<ExpenseIncomeDTO> newExpensesDTOs = updateDTO.getNewExpenses();
			Set<ExpenseIncome> newExpenses = new HashSet<>();
			for(ExpenseIncomeDTO eDTO : newExpensesDTOs) {
				ExpenseIncome ei = null;
				ExpenseIncomeDTO.fillWithData(eDTO, ei);
				newExpenses.add(ei);
			}
			toUpdate.getExpenses().addAll(newExpenses);	
		}
		
		//And finally the incomes
		if(updateDTO.getNewIncomes() != null) {
			Set<ExpenseIncomeDTO> newIncomeDTOS = updateDTO.getNewExpenses();
			Set<ExpenseIncome> newIncomes = new HashSet<>();
			for(ExpenseIncomeDTO eDTO : newIncomeDTOS) {
				ExpenseIncome ei = null;
				ExpenseIncomeDTO.fillWithData(eDTO, ei);
				newIncomes.add(ei);
			}
			toUpdate.getIncomes().addAll(newIncomes);
			
			this.getAccountRepository().updateAccount(toUpdate);
		}
		return;
	}
	
	public AccountRepository getAccountRepository();
}
