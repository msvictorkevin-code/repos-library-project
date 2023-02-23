package com.digital.library.app.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class CreateUserAccountDTOResponse {
    private String userName;
    private String email;
    private String password;
    private boolean userAccountStatus;
}
