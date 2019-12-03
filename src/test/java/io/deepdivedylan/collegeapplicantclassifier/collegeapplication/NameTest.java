package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals(name.accept(), ThreeValueLogic.INDETERMINATE);
    }

    @Test
    public void testRejectIrregularNames() {
        Name badName = new Name("Jean-Luc Picard");
        assertEquals(name.reject(), ThreeValueLogic.FALSE);
        assertEquals(badName.reject(), ThreeValueLogic.TRUE);
    }
}
