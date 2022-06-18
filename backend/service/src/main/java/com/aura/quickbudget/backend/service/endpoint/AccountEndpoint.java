package com.aura.quickbudget.backend.service.endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aura.quickbudget.backend.model.service.SyncAccountAuthorizer;
import com.aura.quickbudget.backend.model.service.SyncAccountService;
import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowable;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

import javax.inject.Named;
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
    
	Logger log = LoggerFactory.getLogger(AccountEndpoint.class);
	
    @Autowired
    SyncAccountService accountSyncService;
    
    @Autowired
    SyncAccountAuthorizer authorizer;
    
    @Autowired 
    HttpServletRequest request;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{accountId}")
    public ResponseEntity<AccountRequestDTO> getAccount(@PathParam("accountId") String accountId){
    	String userId  = null;
    	try {
        	userId = request.getHeader("quickbudget-userId");
        	AccountRequestDTO response =  this.accountSyncService.getAccount(accountId, this.authorizer.getAccount(userId, accountId));
        	return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (AccountThrowableNotFound notFound) {
        	log.debug("Account not found: " + notFound);
        	return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (UnauthorizedException u) {
        	log.debug("Unauthorized user" + userId);
        	return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (AccountThrowable t){
        	log.debug("Bad request" + userId);
        	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }  catch (Exception e) {
        	log.error("Error:" + e);
        	e.printStackTrace();
        	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{accountId}/update")
    public ResponseEntity<Void> updateAccount(@PathParam("accountId") String accountId, @RequestBody UpdateAccountDTO updateDTO) {
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
