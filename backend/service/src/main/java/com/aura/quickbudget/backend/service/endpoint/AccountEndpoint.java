package com.aura.quickbudget.backend.service.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.aura.quickbudget.backend.model.api.Account;
import com.aura.quickbudget.backend.model.service.SyncAccountAuthorizer;
import com.aura.quickbudget.backend.model.service.SyncAccountService;
import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowable;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;
import com.aura.quickbudget.backend.service.repository.api.AccountRepository;

import javax.inject.Named;
import javax.security.auth.login.AccountNotFoundException;
import javax.servlet.http.HttpServletRequest;
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
	private String onlyAccountKey = "onlyaccountkey";
	
	Session will be checked in an external layer.
	*/
    
    @Autowired
    SyncAccountService accountSyncService;
    
    @Autowired
    SyncAccountAuthorizer authorizer;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/[accountId]")
    public ResponseEntity<AccountRequestDTO> getAccount(HttpServletRequest request, @PathParam("accountId") String accountId){
        try {
        	String userId = request.getHeader("quickbudget-userId");
        	AccountRequestDTO response =  this.accountSyncService.getAccount(accountId, this.authorizer.getAccount(userId, accountId));
        	return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AccountThrowableNotFound notFound) {
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException u) {
        	return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (AccountThrowable t){
        	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  catch (Exception e) {
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{accountId}/update")
    public ResponseEntity<Void> updateAccount(HttpServletRequest request, @PathParam("accountId") String accountId, @RequestBody UpdateAccountDTO updateDTO) {
    	try {
        	String userId = request.getHeader("quickbudget-userId");
    		updateDTO.setAccountName(accountId);
    		accountSyncService.updateAccount(updateDTO, this.authorizer.syncAccount(userId, accountId));
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
