package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTestScoreField;

public class StandardizedTestScore implements ApplicationField<StandardizedTestScoreField> {
    private StandardizedTestScoreField standardizedTestScoreField;

    public StandardizedTestScore(StandardizedTestScoreField newStandardizedTestScoreField) {
        standardizedTestScoreField = newStandardizedTestScoreField;
    }

    @Override
    public String getName() {
        return standardizedTestScoreField.getStandardizedTest().name();
    }

    @Override
    public StandardizedTestScoreField getValue() {
        return standardizedTestScoreField;
    }

    @Override
    public boolean accept() {
        return standardizedTestScoreField.getScore() >= standardizedTestScoreField.getStandardizedTest().getMinimumScore();
    }

    @Override
    public boolean reject() {
        return false;
    }
}
