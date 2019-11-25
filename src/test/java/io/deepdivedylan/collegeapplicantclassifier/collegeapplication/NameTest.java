package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameTest {
    private Name name;
    private String testName;

    @BeforeEach
    public void setUp() {
        testName = "Kathryn Janeway";
        name = new Name(testName);
    }

    @Test
    public void testField() {
        assertEquals(name.getName(), "name");
        assertEquals(name.getValue(), testName);
    }

    @Test
    public void testAlwaysAccept() {
        assertTrue(name.accept());
    }

    @Test
    public void testRejectIrregularNames() {
        Name badName = new Name("Jean-Luc Picard");
        assertFalse(name.reject());
        assertTrue(badName.reject());
    }
}
