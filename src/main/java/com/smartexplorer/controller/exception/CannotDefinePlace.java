package com.smartexplorer.controller.exception;

/**
 * @Author
 * Karol Meksuła
 * 08-06-2018
 * */

public class CannotDefinePlace extends RuntimeException {

    @Override
    public String getMessage() {
        return "Algorithm cannot define place or places.\nCheck if request JSON is correct.";
    }

}
