package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.GpaField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GpaTest {
    private GpaField gpaField;
    private Gpa gpa;

    @BeforeEach
    public void setUp() {
        gpaField = new GpaField(4.8, 5.0);
        gpa = new Gpa(gpaField);
    }

    @Test
    public void testField() {
        assertEquals(gpa.getName(), "gpa");
        assertEquals(gpa.getValue(), gpaField);
    }

    @Test
    public void testAcceptHighGpas() {
        GpaField lowGpaField = new GpaField(4.2, 5.0);
        Gpa lowGpa = new Gpa(lowGpaField);
        assertEquals(gpa.accept(), ThreeValueLogic.TRUE);
        assertEquals(lowGpa.accept(), ThreeValueLogic.FALSE);
    }

    @Test
    public void testRejectLowGpas() {
        GpaField lowGpaField = new GpaField(3.2, 5.0);
        Gpa lowGpa = new Gpa(lowGpaField);
        assertEquals(gpa.reject(), ThreeValueLogic.FALSE);
        assertEquals(lowGpa.reject(), ThreeValueLogic.TRUE);
    }
}
