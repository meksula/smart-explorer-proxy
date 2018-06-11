package com.smartexplorer.domain.subject.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author
 * Karol Meksuła
 * 11-06-2018
 * */

@Getter
@Document(collection = "confirmation")
public class Confirmation {

    @Id
    private String id;

    private String principalNumber;
    private String verificationCode;

    public Confirmation(@JsonProperty("principalNumber") String principalNumber,
                        @JsonProperty("verificationCode") String verificationCode) {
        this.principalNumber = principalNumber;
        this.verificationCode = verificationCode;
    }

    public void setId(String id) {
        this.id = id;
    }

}
