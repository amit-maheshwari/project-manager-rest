package com.cognizant.learn.projectManager.model;

public class ErrorDetail {

    private String errorMessage;

    public ErrorDetail(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
