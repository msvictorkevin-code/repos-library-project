package com.digital.library.app.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;


@Builder
@JsonPropertyOrder({"idReader", "userName", "readerName", "addressReader", "userProfileId", "status", "message"})
@Data
public class ReaderResponse {

    private Long idReader;
    private String userName;
    private String readerName;
    private String addressReader;
    private Long userProfileId;
    private Boolean status;
    private String message;
}
