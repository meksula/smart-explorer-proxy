package com.smartexplorer.domain.subject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Document(collection = "spotmaker")
public class SpotMaker implements Serializable {

    @Id
    private String spotMakerId;

    private boolean confirmed;
    private String principalNumber;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private int age;

}
