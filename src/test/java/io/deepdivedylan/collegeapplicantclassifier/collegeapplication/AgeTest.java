package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(age.accept());
    }

    @Test
    public void testRejectNegativeAges() {
        Age negativeAge = new Age(-testAge);
        assertFalse(age.reject());
        assertTrue(negativeAge.reject());
    }
}