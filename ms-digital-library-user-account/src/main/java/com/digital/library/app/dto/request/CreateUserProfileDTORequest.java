package com.digital.library.app.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CreateUserProfileDTORequest {
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;

    @JsonProperty("account")
    CreateUserAccountDTORequest userAccountDTORequest;
}
