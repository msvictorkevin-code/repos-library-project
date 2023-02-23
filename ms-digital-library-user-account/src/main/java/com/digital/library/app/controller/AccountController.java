package com.digital.library.app.controller;

import com.digital.library.app.dto.request.CreateUserProfileDTORequest;
import com.digital.library.app.dto.response.CreateUserProfileDTOResponse;
import com.digital.library.app.service.AccountService;
import constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(Constants.API_ACCOUNT)
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping
    public ResponseEntity<CreateUserProfileDTOResponse> save(@RequestBody CreateUserProfileDTORequest createUserProfileDTORequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(createUserProfileDTORequest));
    }

}
