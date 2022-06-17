package com.aura.quickbudget.backend.model.service;

import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

public interface SyncAccountAuthorizer {
	public SyncAuthorizationToken getAccount(String username, String accountId) throws UnauthorizedException;
	public SyncAuthorizationToken syncAccount(String username, String accountId) throws UnauthorizedException;
}
