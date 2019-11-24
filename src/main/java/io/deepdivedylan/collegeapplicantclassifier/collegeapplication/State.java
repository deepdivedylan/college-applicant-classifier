package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

public class State implements ApplicationField<String> {
    private String state;

    public State(String newState) {
        state = newState;
    }

    @Override
    public String getName() {
        return "state";
    }

    @Override
    public String getValue() {
        return state;
    }

    @Override
    public boolean accept() {
        return true;
    }

    @Override
    public boolean reject() {
        return false;
    }
}
