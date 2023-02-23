package com.digital.library.app.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Reader")
public class Reader implements Serializable {

    @Id
    private String id= UUID.randomUUID().toString();

    @Field("idReader")
    private Long idReader;

    @Field("username")
    private String userName;

    @Field("readerName")
    private String readerName;

    @Field("addressReader")
    private String addressReader;

    @Field("userProfileId")
    private Long userProfileId;
 

}
