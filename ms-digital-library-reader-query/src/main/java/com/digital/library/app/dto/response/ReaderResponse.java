package com.digital.library.app.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReaderResponse {

    private Long idReader;
    private String userName;
    private String readerName;
    private String addressReader;
    private Long userProfileId;
}
