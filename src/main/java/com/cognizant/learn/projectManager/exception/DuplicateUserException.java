package com.cognizant.learn.projectManager.exception;

import java.util.Locale;

public class DuplicateUserException extends RuntimeException {
    private Locale locale;
    private String id;
    public DuplicateUserException(String message, String id) {this(message,id, Locale.getDefault());}

    public DuplicateUserException(String message, String id, Locale locale) {
        super(message);
        this.locale = locale;
        this.id = id;
    }


    public DuplicateUserException(String message, String id, Throwable cause) {
        super(message, cause);
        this.locale = Locale.getDefault();
        this.id = id;
    }

    public Locale getLocale() {
        return locale;
    }

    public String getId() {
        return id;
    }
}
