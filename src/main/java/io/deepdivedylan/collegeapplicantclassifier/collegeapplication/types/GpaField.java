package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types;

public class GpaField {
    private double gpa;
    private double perfectGpa;

    public GpaField(double newGpa, double newPerfectGpa) {
        setGpa(newGpa);
        setPerfectGpa(newPerfectGpa);
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getPerfectGpa() {
        return perfectGpa;
    }

    public void setPerfectGpa(double perfectGpa) {
        this.perfectGpa = perfectGpa;
    }
}
