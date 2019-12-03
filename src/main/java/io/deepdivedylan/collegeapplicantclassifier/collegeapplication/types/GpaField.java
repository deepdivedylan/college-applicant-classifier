package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types;

public class GpaField {
    private double gpa;
    private double perfectGpa;

    public GpaField(double newGpa, double newPerfectGpa) {
        gpa = newGpa;
        perfectGpa = newPerfectGpa;
    }

    public double getGpa() {
        return gpa;
    }

    public double getPerfectGpa() {
        return perfectGpa;
    }

    @Override
    public String toString() {
        return gpa + " / " + perfectGpa;
    }
}
