package com.digital.library.app.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@JsonPropertyOrder({"firstName", "lastName","fullName", "email", "account","status","message" })
@Builder
@ToString
@Data
public class CreateUserProfileDTOResponse {
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;

    @JsonProperty("account")
    CreateUserAccountDTOResponse userAccountDTOResponse;

    private Boolean status;
    private String message;
}
