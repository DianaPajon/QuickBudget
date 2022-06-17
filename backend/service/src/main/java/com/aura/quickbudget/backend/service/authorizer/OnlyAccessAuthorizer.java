package com.aura.quickbudget.backend.service.authorizer;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.aura.quickbudget.backend.model.service.SyncAccountAuthorizer;
import com.aura.quickbudget.backend.model.service.SyncAuthorizationToken;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

@Component
public class OnlyAccessAuthorizer implements SyncAccountAuthorizer {

	@Override
	public SyncAuthorizationToken getAccount(String username, String accountId) throws UnauthorizedException {
		if(
			!Objects.equals(username, "diana") || 
			!Objects.equals(accountId, "aura")
		) {
			throw new UnauthorizedException();
		} else {
			return SyncAuthorizationToken.GET_ACCOUNT;
		}
	}

	@Override
	public SyncAuthorizationToken syncAccount(String username, String accountId) throws UnauthorizedException  {
		if(
			!Objects.equals(username, "diana") || 
			!Objects.equals(accountId, "aura")
		) {
			throw new UnauthorizedException();
		} else {
			return SyncAuthorizationToken.SYNC_ACCOUNT;
		}
	}

}
