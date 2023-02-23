package com.digital.library.app.service;

import com.digital.library.app.dto.request.CreateUserProfileDTORequest;
import com.digital.library.app.dto.response.CreateUserAccountDTOResponse;
import com.digital.library.app.dto.response.CreateUserProfileDTOResponse;
import com.digital.library.app.entity.UserAccount;
import com.digital.library.app.entity.UserProfile;
import com.digital.library.app.repository.UserAccountRepository;
import com.digital.library.app.repository.UserProfileRepository;
import com.digital.library.app.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class AccountServiceImpl implements AccountService {
    private UserAccountRepository accountRepository;
    private UserProfileRepository userProfileRepository;

    public AccountServiceImpl(UserAccountRepository accountRepository, UserProfileRepository userProfileRepository) {
        this.accountRepository = accountRepository;
        this.userProfileRepository = userProfileRepository;
    }


    @Transactional
    @Override
    public CreateUserProfileDTOResponse create(CreateUserProfileDTORequest createUserProfileDTORequest) {
        try {
            UserProfile userProfile = Util.buildUserProfile(createUserProfileDTORequest);
            UserAccount userAccount = Util.buildUserAccount(createUserProfileDTORequest);
            userProfile = userProfileRepository.save(userProfile);
            userAccount.setUserProfileId(userProfile.getId());
            userAccount = accountRepository.save(userAccount);
            return CreateUserProfileDTOResponse.builder()
                    .firstName(userProfile.getFirstName())
                    .lastName(userProfile.getLastName()).fullName(userProfile.getFullName())
                    .email(userProfile.getEmail())
                    .userAccountDTOResponse(CreateUserAccountDTOResponse.builder().userName(userAccount.getUserName()).email(userAccount.getEmail()).password(userAccount.getPassword()).userAccountStatus(userAccount.isUserAccountStatus()).build()).
                            message("Registrado correctamente.").status(true).build();


        } catch (Exception ex) {
            log.error("Error: " + ex.getLocalizedMessage());
        }
        return CreateUserProfileDTOResponse.builder()
                .firstName(null)
                .lastName(null)
                .email(null)
                .userAccountDTOResponse(null).
                        message("Error al registrar correctamente.").status(false).build();
    }

}
