package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.Age;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.State;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InStateTest {
    private Age age;
    private State state;
    private InState rule;

    @BeforeEach
    public void setUp() {
        age = new Age(21);
        state = new State("CA");
        rule = new InState(age, state);
    }

    @Test
    public void testAcceptYoungCalifornian() {
        assertEquals(rule.accept(), ThreeValueLogic.TRUE);
    }

    @Test
    public void testAcceptOldFolks() {
        Age oldFolk = new Age(86);
        State outOfState = new State("NM");
        InState oldFolksRule = new InState(oldFolk, outOfState);
        assertEquals(oldFolksRule.accept(), ThreeValueLogic.TRUE);
    }

    @Test
    public void testRejectOtherPeople() {
        Age middleAged = new Age(42);
        InState middleAgedRule = new InState(middleAged, state);
        assertEquals(middleAgedRule.accept(), ThreeValueLogic.FALSE);
    }
}
