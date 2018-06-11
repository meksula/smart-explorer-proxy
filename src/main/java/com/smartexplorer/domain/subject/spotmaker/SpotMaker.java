package com.smartexplorer.domain.subject.spotmaker;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.smartexplorer.domain.mail.MailReceiver;
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
public class SpotMaker implements Serializable, MailReceiver {

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

    public SpotMaker() {}

    public SpotMaker(SpotMakerBuilder builder) {
        this.spotMakerId = builder.spotMakerId;
        this.confirmed = builder.confirmed;
        this.principalNumber = builder.principalNumber;
        this.username = builder.username;
        this.password = builder.password;
        this.name = builder.name;
        this.surname = builder.surname;
        this.email = builder.email;
        this.age = builder.age;
    }

    public static class SpotMakerBuilder {
        private String spotMakerId;
        private boolean confirmed;
        private String principalNumber;
        private String username;
        private String password;
        private String name;
        private String surname;
        private String email;
        private int age;

        public SpotMakerBuilder spotMakerId(String spotMakerId) {
            this.spotMakerId = spotMakerId;
            return this;
        }

        public SpotMakerBuilder isConfirmed(boolean confirmed) {
            this.confirmed = confirmed;
            return this;
        }

        public SpotMakerBuilder principalNumber(String principalNumber) {
            this.principalNumber = principalNumber;
            return this;
        }

        public SpotMakerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public SpotMakerBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SpotMakerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SpotMakerBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public SpotMakerBuilder email(String email) {
            this.email = email;
            return this;
        }

        public SpotMakerBuilder age(int age) {
            this.age = age;
            return this;
        }

        public SpotMaker build() {
            return new SpotMaker(this);
        }
    }
}
