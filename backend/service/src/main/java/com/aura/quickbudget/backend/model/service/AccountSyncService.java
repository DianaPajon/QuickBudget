package com.aura.quickbudget.backend.model.service;

import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidExpenseIncome;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableInvalidMovement;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;

public interface AccountSyncService {
	public AccountRequestDTO getAccount(String accountName) throws AccountThrowableNotFound;
	public void updateAccount(UpdateAccountDTO updateDTO) 
			throws 			
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableNotFound, 
				AccountThrowableInvalidMovement, 
				AccountThrowableMovementsNotConsecutive, 
				AccountThrowableInvalidExpenseIncome; 

}
