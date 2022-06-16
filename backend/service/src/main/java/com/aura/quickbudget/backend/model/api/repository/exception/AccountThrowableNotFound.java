package com.aura.quickbudget.backend.model.api.repository.exception;

public class AccountThrowableNotFound extends AccountThrowable {
	
	private static final long serialVersionUID = -5584488219644016943L;
	
	private Exception persistenceException;
	private String name;
	public AccountThrowableNotFound(String name) {
		super();
		this.name = name;
	}
	
	public AccountThrowableNotFound(String name, Exception e) {
		super();
		this.name = name;
		this.persistenceException = e;
	}
	
	
	public Exception getPersistenceException() {
		return this.persistenceException;
	}
}
