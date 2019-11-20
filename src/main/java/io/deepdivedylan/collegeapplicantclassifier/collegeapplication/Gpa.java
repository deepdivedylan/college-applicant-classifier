package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.GpaField;

public class Gpa implements ApplicationField<GpaField> {
    private GpaField gpa;

    @Override
    public String getName() {
        return "gpa";
    }

    @Override
    public void setValue(GpaField newValue) {
        gpa = newValue;
    }

    @Override
    public GpaField getValue() {
        return gpa;
    }

    @Override
    public boolean accept() {
        return (gpa.getGpa() / gpa.getPerfectGpa()) > 0.9;
    }

    @Override
    public boolean reject() {
        return (gpa.getGpa() / gpa.getPerfectGpa()) < 0.7;
    }
}
