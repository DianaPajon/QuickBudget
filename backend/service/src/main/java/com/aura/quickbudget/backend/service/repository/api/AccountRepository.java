package com.aura.quickbudget.backend.service.repository.api;

import java.util.List;
import java.util.Set;

import com.aura.quickbudget.backend.model.api.Account;
import com.aura.quickbudget.backend.model.api.ExpenseIncome;
import com.aura.quickbudget.backend.model.api.Movement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.quickbudget.backend.model.api.Income;


public interface AccountRepository {
	public Account getAccount(String accountId) throws AccountThrowableNotFound;
	public void updateAccount(Account account)  throws AccountThrowableNotFound, AccountThrowableMovementsNotConsecutive;
}
