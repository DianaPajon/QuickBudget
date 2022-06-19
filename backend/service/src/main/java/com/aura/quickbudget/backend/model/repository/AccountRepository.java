package com.aura.quickbudget.backend.model.repository;


import com.aura.quickbudget.backend.model.entities.Account;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;


public interface AccountRepository {
	public Account getAccount(String accountId) throws AccountThrowableNotFound;
	public void updateAccount(Account account)  throws AccountThrowableNotFound, AccountThrowableMovementsNotConsecutive;
}
