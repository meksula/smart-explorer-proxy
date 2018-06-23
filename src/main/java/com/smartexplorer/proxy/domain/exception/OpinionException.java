package com.smartexplorer.proxy.domain.exception;

/**
 * @Author
 * Karol Meksuła
 * 23-06-2018
 * */

public class OpinionException extends RuntimeException {
    private static String message;

    public OpinionException() {}

    public OpinionException(String message) {
        OpinionException.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
