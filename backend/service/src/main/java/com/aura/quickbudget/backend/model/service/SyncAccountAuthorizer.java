package com.aura.quickbudget.backend.model.service;

import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

public interface SyncAccountAuthorizer {
	
	public interface Token{
		public String getAuthorizedUser();
	}
	
	public interface GetAccountToken extends Token{}
	public GetAccountToken getAccount(String username, String accountId) throws UnauthorizedException;
	
	public interface SyncAccountToken extends Token{}
	public SyncAccountToken syncAccount(String username, String accountId) throws UnauthorizedException;
	
	
}
