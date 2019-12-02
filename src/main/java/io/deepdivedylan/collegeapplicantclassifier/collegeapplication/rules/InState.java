package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.Age;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.State;

public class InState implements Rule<Age, State> {
    private Age age;
    private State state;

    public InState(Age newAge, State newState) {
        age = newAge;
        state = newState;
    }

    public Age getLeft() {
        return age;
    }

    public State getRight() {
        return state;
    }

    public boolean accept() {
        return (age.getValue() > 17 && age.getValue() < 26 && state.getValue().equals("CA")) || age.getValue() > 80;
    }

    public boolean reject() {
        return false;
    }
}
