package com.aura.quickbudget.backend.service;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.quickbudget.backend.model.api.Account;
import com.quickbudget.backend.model.api.repository.AccountCrudRepository;
import com.quickbudget.backend.model.api.repository.exception.ObjectNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Named
@Path("/")
public class InitialEndpoint {
    
	/*
	@Inject
    NamedParameterJdbcTemplate jdbcTemplate;
*/
    @Autowired
    AccountCrudRepository accountCrud;
    @GET
    public String hello() {
        return "Hello World!";
    }


    // SQL sample
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("calc")
    public Account getOnlyAccount(@QueryParam("id") String accountId) {
    	try {
    		return accountCrud.getAccount(accountId);	
    	} catch (ObjectNotFoundException notFound) {
    		return null;
    	} catch (Exception e) {
    		return null;
    	}
    	
    }
}
