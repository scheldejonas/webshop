package com.cupcakes.webshop.web;

/**
 * Created by scheldejonas on 10/09/16.
 */
public class FlashMessage {
    private String message;
    private Status status;

    public FlashMessage(String message, Status status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }

    public static enum Status {
        SUCCES, FAILURE
    }
}
