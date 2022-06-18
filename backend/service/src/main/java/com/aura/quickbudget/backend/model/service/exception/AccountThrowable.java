package com.aura.quickbudget.backend.model.service.exception;

public class AccountThrowable extends Throwable{

	private static final long serialVersionUID = 8736761819856783359L;

	public AccountThrowable() {
		super("Account exception", null, false, false);
	}
}
