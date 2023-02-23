package com.digital.library.app.service;


import com.digital.library.app.dto.request.CreateUserProfileDTORequest;

import com.digital.library.app.dto.response.CreateUserProfileDTOResponse;

public interface AccountService {

  CreateUserProfileDTOResponse create (CreateUserProfileDTORequest createUserProfileDTORequest);
}
