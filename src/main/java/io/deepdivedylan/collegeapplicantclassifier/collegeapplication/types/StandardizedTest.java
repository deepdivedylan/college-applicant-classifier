package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types;

public enum StandardizedTest {
    ACT(27), SAT(1920);

    private int minimumScore;

    private StandardizedTest(int newMinimumScore) {
        minimumScore = newMinimumScore;
    }

    public int getMinimumScore() {
        return minimumScore;
    }
}
