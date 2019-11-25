package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(state.accept());
    }

    @Test
    public void testNeverReject() {
        assertFalse(state.reject());
    }
}
