package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.GpaField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

public class Gpa implements ApplicationField<GpaField> {
    private GpaField gpa;

    public Gpa(GpaField newGpa) {
        gpa = newGpa;
    }

    @Override
    public String getName() {
        return "gpa";
    }

    @Override
    public GpaField getValue() {
        return gpa;
    }

    @Override
    public ThreeValueLogic accept() {
        return ThreeValueLogic.fromBoolean((gpa.getGpa() / gpa.getPerfectGpa()) > 0.9);
    }

    @Override
    public ThreeValueLogic reject() {
        return ThreeValueLogic.fromBoolean((gpa.getGpa() / gpa.getPerfectGpa()) < 0.7);
    }
}
