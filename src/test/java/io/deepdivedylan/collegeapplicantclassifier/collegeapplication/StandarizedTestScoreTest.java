package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTest;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTestScoreField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandarizedTestScoreTest {
    private int[] failingScores = new int[] {26, 1919};
    private int[] passingScores = new int[] {27, 1920};
    private StandardizedTestScoreField[] failingStandardizedTestScoreFields = new StandardizedTestScoreField[StandardizedTest.values().length];
    private StandardizedTestScoreField[] passingStandardizedTestScoreFields = new StandardizedTestScoreField[StandardizedTest.values().length];
    private StandardizedTestScore[] failingStandardizedTestScores = new  StandardizedTestScore[StandardizedTest.values().length];
    private StandardizedTestScore[] passingStandardizedTestScores = new StandardizedTestScore[StandardizedTest.values().length];

    @BeforeEach
    public void setUp() {
        int i = 0;
        for (StandardizedTest standardizedTest : StandardizedTest.values()) {
            failingStandardizedTestScoreFields[i] = new StandardizedTestScoreField(standardizedTest, failingScores[i]);
            passingStandardizedTestScoreFields[i] = new StandardizedTestScoreField(standardizedTest, passingScores[i]);
            failingStandardizedTestScores[i] = new StandardizedTestScore(failingStandardizedTestScoreFields[i]);
            passingStandardizedTestScores[i] = new StandardizedTestScore(passingStandardizedTestScoreFields[i]);
            i++;
        }
    }

    @Test
    public void testField() {
        int i = 0;
        for (StandardizedTestScore standardizedTestScore : failingStandardizedTestScores) {
            assertEquals(standardizedTestScore.getValue().getScore(), failingScores[i]);
            i++;
        }
        i = 0;
        for (StandardizedTestScore standardizedTestScore : passingStandardizedTestScores) {
            assertEquals(standardizedTestScore.getValue().getScore(), passingScores[i]);
            i++;
        }
    }

    @Test
    public void testAcceptsPassingScores() {
        for (StandardizedTestScore standardizedTestScore : failingStandardizedTestScores) {
            assertEquals(standardizedTestScore.accept(), ThreeValueLogic.FALSE);
        }
        for (StandardizedTestScore standardizedTestScore : passingStandardizedTestScores) {
            assertEquals(standardizedTestScore.accept(), ThreeValueLogic.TRUE);
        }
    }

    @Test
    public void testNeverReject() {
        for (StandardizedTestScore standardizedTestScore : failingStandardizedTestScores) {
            assertEquals(standardizedTestScore.reject(), ThreeValueLogic.INDETERMINATE);
        }
        for (StandardizedTestScore standardizedTestScore : passingStandardizedTestScores) {
            assertEquals(standardizedTestScore.reject(), ThreeValueLogic.INDETERMINATE);
        }
    }
}
