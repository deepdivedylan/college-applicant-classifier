package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeTest {
    private Age age;
    private static final int testAge = 42;

    @BeforeEach
    void setUp() {
        age = new Age(testAge);
    }

    @Test
    public void testField() {
        assertEquals(age.getName(), "age");
        assertEquals(age.getValue(), testAge);
    }

    @Test
    public void testAlwaysAccept() {
        assertEquals(age.accept(), ThreeValueLogic.INDETERMINATE);
    }

    @Test
    public void testRejectNegativeAges() {
        Age negativeAge = new Age(-testAge);
        assertEquals(age.reject(), ThreeValueLogic.FALSE);
        assertEquals(negativeAge.reject(), ThreeValueLogic.TRUE);
    }
}