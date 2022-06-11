package com.quickbudget.backend.model.api.repository.exception;

public class ObjectNotFoundException extends Exception {
	
	private Exception persistenceException;
	private Class c;
	public ObjectNotFoundException(Exception e, Class c) {
		this.persistenceException = e;
		this.c = c;
	}
	
	public Class getObjectClass() {
		return c;
	}
	public Exception getPersistenceException() {
		return this.persistenceException;
	}
}
