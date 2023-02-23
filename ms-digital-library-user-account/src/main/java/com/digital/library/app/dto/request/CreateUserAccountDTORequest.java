package com.digital.library.app.dto.request;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class CreateUserAccountDTORequest {


    private String userName;
    private String email;
    private String password;

}
