package com.smartexplorer.proxy.domain.exception;

/**
 * @Author
 * Karol Meksuła
 * 17-06-2018
 * */

public class CannotFindAnySpot extends RuntimeException {
    private static String message;

    public CannotFindAnySpot() {}

    public CannotFindAnySpot(String message) {
        CannotFindAnySpot.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
