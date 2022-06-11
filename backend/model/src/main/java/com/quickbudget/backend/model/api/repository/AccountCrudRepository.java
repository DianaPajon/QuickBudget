package com.quickbudget.backend.model.api.repository;

import com.quickbudget.backend.model.api.Account;
import com.quickbudget.backend.model.api.repository.exception.ObjectNotFoundException;


public interface AccountCrudRepository {
	public Account getAccount(String accountId) throws ObjectNotFoundException; 
}
