package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types;

public class StandardizedTestScoreField {
    private StandardizedTest standardizedTest;
    private int score;

    public StandardizedTestScoreField(StandardizedTest newStandardizedTest, int newScore) {
        setStandardizedTest(newStandardizedTest);
        setScore(newScore);
    }

    public StandardizedTest getStandardizedTest() {
        return standardizedTest;
    }

    public void setStandardizedTest(StandardizedTest standardizedTest) {
        this.standardizedTest = standardizedTest;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
