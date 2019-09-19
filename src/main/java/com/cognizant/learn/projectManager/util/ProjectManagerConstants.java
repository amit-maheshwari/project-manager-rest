package com.cognizant.learn.projectManager.util;

public enum ProjectManagerConstants {

    UNEXPECTED_INTERNAL_ERROR("unexpected.internal.error"),
    DUPLICATE_EXCEPTION("Duplicate Exception");

    private String value;
    ProjectManagerConstants(String value){this.value = value;}

    public String getValue(){return this.value;}

}
