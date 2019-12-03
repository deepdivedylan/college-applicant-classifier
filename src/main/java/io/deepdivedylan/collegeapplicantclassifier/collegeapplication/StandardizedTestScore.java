package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTestScoreField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

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
    public ThreeValueLogic accept() {
        return ThreeValueLogic.fromBoolean(standardizedTestScoreField.getScore() >= standardizedTestScoreField.getStandardizedTest().getMinimumScore());
    }

    @Override
    public ThreeValueLogic reject() {
        return ThreeValueLogic.INDETERMINATE;
    }
}
