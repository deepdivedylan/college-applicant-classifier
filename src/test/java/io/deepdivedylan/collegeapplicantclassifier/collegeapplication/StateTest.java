package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateTest {
    private State state;
    private String testState;

    @BeforeEach
    public void setUp() {
        testState = "CA";
        state = new State(testState);
    }

    @Test
    public void testField() {
        assertEquals(state.getName(), "state");
        assertEquals(state.getValue(), testState);
    }

    @Test
    public void testAlwaysAccept() {
        assertEquals(state.accept(), ThreeValueLogic.INDETERMINATE);
    }

    @Test
    public void testNeverReject() {
        assertEquals(state.reject(), ThreeValueLogic.INDETERMINATE);
    }
}
