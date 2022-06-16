package com.aura.quickbudget.backend.service.service;

import com.aura.quickbudget.backend.model.api.repository.exception.AccountThrowableMovementsNotConsecutive;
import com.aura.quickbudget.backend.model.api.repository.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.service.endpoint.operationdto.AccountRequestDTO;
import com.aura.quickbudget.backend.service.endpoint.operationdto.UpdateAccountDTO;

public interface AccountSyncService {
	public AccountRequestDTO getAccount(String accountName) throws AccountThrowableNotFound;
	public void updateAccount(UpdateAccountDTO updateDTO) throws AccountThrowableMovementsNotConsecutive, AccountThrowableNotFound;
}
