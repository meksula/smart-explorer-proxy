package com.smartexplorer.controller;

import com.smartexplorer.controller.exception.CannotDefinePlace;
import com.smartexplorer.controller.exception.UserCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author
 * Karol Meksuła
 * 10-06-2018
 * */

@RestControllerAdvice
public class ExceptionHandlerCotroller {

    @ExceptionHandler(CannotDefinePlace.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String cannotDefinePlace() {
        return new CannotDefinePlace().getMessage();
    }

    @ExceptionHandler(UserCreationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userCreationException() {
        return new UserCreationException().getMessage();
    }

}
