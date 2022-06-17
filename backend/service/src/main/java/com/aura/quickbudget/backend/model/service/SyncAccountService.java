package com.aura.quickbudget.backend.model.service;

import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidExpenseIncome;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidMovement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

public interface SyncAccountService {
	public AccountRequestDTO getAccount(String accountName, SyncAuthorizationToken token) 
			throws 
				AccountThrowableNotFound,
				UnauthorizedException;
	
	public void updateAccount(UpdateAccountDTO updateDTO, SyncAuthorizationToken token) 
			throws 			
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableNotFound, 
				AccountThrowableInvalidMovement, 
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableInvalidExpenseIncome,
				UnauthorizedException; 

}
