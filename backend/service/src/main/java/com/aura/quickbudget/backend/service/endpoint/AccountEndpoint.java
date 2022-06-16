package com.aura.quickbudget.backend.service.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aura.quickbudget.backend.model.api.Account;
import com.aura.quickbudget.backend.model.api.repository.AccountRepository;
import com.aura.quickbudget.backend.model.api.repository.exception.AccountThrowable;
import com.aura.quickbudget.backend.model.api.repository.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.service.endpoint.operationdto.AccountRequestDTO;
import com.aura.quickbudget.backend.service.endpoint.operationdto.UpdateAccountDTO;
import com.aura.quickbudget.backend.service.service.AccountSyncService;

import javax.inject.Named;
import javax.security.auth.login.AccountNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Named
@Path("/account")
public class AccountEndpoint {
    
	/*
	@Inject
    NamedParameterJdbcTemplate jdbcTemplate;
*/
	
	private String onlyAccountKey = "onlyaccountkey";
	
    
    @Autowired
    AccountSyncService accountSyncService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/[accountId]")
    public ResponseEntity<AccountRequestDTO> getAccount(@PathParam("accountId") String accountId){
        try {
        	AccountRequestDTO response =  this.accountSyncService.getAccount(accountId);
        	return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AccountThrowableNotFound notFound) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (AccountThrowable t){
        	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{accountId}/update")
    public ResponseEntity<Void> updateAccount(@PathParam("accountId") String accountId, @RequestBody UpdateAccountDTO updateDTO) {
    	try {
    		updateDTO.setAccountName(accountId);
    		accountSyncService.updateAccount(updateDTO);
    		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    	} catch (AccountThrowableNotFound notFound) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (AccountThrowable t){
        	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    	
    }
  
}
