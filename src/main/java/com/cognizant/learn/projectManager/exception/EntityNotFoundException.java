package com.cognizant.learn.projectManager.exception;

import java.util.Locale;

public class EntityNotFoundException extends RuntimeException {
    private Locale locale;
    private Long id;
    public EntityNotFoundException(String message, Long id) {this(message,id, Locale.getDefault());}

    public EntityNotFoundException(String message, Long id, Locale locale) {
        super(message);
        this.locale = locale;
        this.id = id;
    }


    public EntityNotFoundException(String message, Long id, Throwable cause) {
        super(message, cause);
        this.locale = Locale.getDefault();
        this.id = id;
    }

    public Locale getLocale() {
        return locale;
    }

    public Long getId() {
        return id;
    }


}
