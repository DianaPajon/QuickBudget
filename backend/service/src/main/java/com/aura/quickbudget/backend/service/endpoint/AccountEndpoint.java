package com.aura.quickbudget.backend.service.endpoint;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aura.quickbudget.backend.model.service.SyncAccountAuthorizer;
import com.aura.quickbudget.backend.model.service.SyncAccountService;
import com.aura.quickbudget.backend.model.service.dto.getaccount.AccountRequestDTO;
import com.aura.quickbudget.backend.model.service.dto.updateaccount.UpdateAccountDTO;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowable;
import com.aura.quickbudget.backend.model.service.exception.AccountThrowableNotFound;
import com.aura.quickbudget.backend.model.service.exception.UnauthorizedException;

@RestController
@RequestMapping("/account")
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

    interface GeneralEndpoint<ResponseFormat> {
    	public ResponseFormat run(String userId) throws AccountThrowable;
    }
    
    private <Entity> ResponseEntity<Entity> getResponse(GeneralEndpoint<Entity> endpoint){
    	String userId  = null;
    	try {
        	userId = request.getHeader("quickbudget-userId");
        	Entity response =  endpoint.run(userId);
        	return new ResponseEntity<>(response, response==null?HttpStatus.NO_CONTENT:HttpStatus.OK);
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
    
    @GetMapping(path="/{accountId}", produces="application/json")
    public ResponseEntity<AccountRequestDTO> getAccount(@PathVariable("accountId") String accountId){
    	return this.getResponse(new GeneralEndpoint<AccountRequestDTO>() {
			@Override
			public AccountRequestDTO run(String userId) throws AccountThrowable {
				return accountSyncService.getAccount(accountId, authorizer.getAccount(userId, accountId));
			}
		});
    }
    
    @PostMapping(path="/{accountId}/update", consumes = "application/json")
    public ResponseEntity<Void> updateAccount(@PathVariable("accountId") String accountId, @RequestBody UpdateAccountDTO updateDTO) {
    	return this.getResponse(new GeneralEndpoint<Void>() {
			@Override
			public Void run(String userId) throws AccountThrowable {
				accountSyncService.updateAccount(updateDTO, authorizer.syncAccount(userId, accountId));
				return null;
			}
		});
    }
  
}
