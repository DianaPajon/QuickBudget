package com.aura.quickbudget.backend.service.authorizer;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.aura.quickbudget.backend.model.service.authorizer.SyncAccountAuthorizer;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

@Component
public class OnlyAccessAuthorizer implements SyncAccountAuthorizer {

	@Override
	public GetAccountToken getAccount(String username, String accountId) throws UnauthorizedException {
		if(
			!Objects.equals(username, "diana") || 
			!Objects.equals(accountId, "aura")
		) {
			throw new UnauthorizedException();
		} else {
			return new GetAccountToken() {
				String userID = username;

				@Override
				public String getAuthorizedUser() {
					return userID;
				}
				
			};
		}
	}

	@Override
	public SyncAccountToken syncAccount(String username, String accountId) throws UnauthorizedException  {
		if(
			!Objects.equals(username, "diana") || 
			!Objects.equals(accountId, "aura")
		) {
			throw new UnauthorizedException();
		} else {
			return new SyncAccountToken() {
				String userID = username;
				
				@Override
				public String getAuthorizedUser() {
					return userID;
				}
				
			};
		}
	}

}
