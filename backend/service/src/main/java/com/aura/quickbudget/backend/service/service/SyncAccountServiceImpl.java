package com.aura.quickbudget.backend.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aura.quickbudget.backend.model.repository.api.AccountRepository;
import com.aura.quickbudget.backend.model.service.SyncAccountService;

@Component
public class SyncAccountServiceImpl implements SyncAccountService{

	@Autowired
	private AccountRepository accountRepo;

	@Override
	public AccountRepository getAccountRepository() {
		return this.accountRepo;
	}
			
}
