package com.digital.library.app.util;

import com.digital.library.app.dto.request.CreateUserAccountDTORequest;
import com.digital.library.app.dto.request.CreateUserProfileDTORequest;
import com.digital.library.app.entity.UserAccount;
import com.digital.library.app.entity.UserProfile;

public class Util {

    public static UserAccount buildUserAccount(CreateUserProfileDTORequest userAccountDTORequest) {
        UserAccount userAccount = new UserAccount();
        CreateUserAccountDTORequest createUserAccountDTORequest = userAccountDTORequest.getUserAccountDTORequest();
        userAccount.setUserName(createUserAccountDTORequest.getUserName());
        userAccount.setEmail(createUserAccountDTORequest.getEmail());
        userAccount.setPassword(createUserAccountDTORequest.getPassword());
        return userAccount;
    }

    public static UserProfile buildUserProfile(CreateUserProfileDTORequest userAccountDTORequest) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(userAccountDTORequest.getFirstName());
        userProfile.setLastName(userAccountDTORequest.getLastName());
        userProfile.setFullName(userAccountDTORequest.getFullName());
        userProfile.setEmail(userAccountDTORequest.getEmail());
        return userProfile;
    }
}
