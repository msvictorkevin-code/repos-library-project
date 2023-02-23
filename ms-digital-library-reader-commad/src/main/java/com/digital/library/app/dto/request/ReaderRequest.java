package com.digital.library.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReaderRequest {
    private String id;
    private Long idReader;
    private String userName;
    private String readerName;
    private String addressReader;
    private Long userProfileId;

}
