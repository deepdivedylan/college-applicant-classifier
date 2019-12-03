package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

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
    public ThreeValueLogic accept() {
        return ThreeValueLogic.INDETERMINATE;
    }

    @Override
    public ThreeValueLogic reject() {
        return ThreeValueLogic.INDETERMINATE;
    }
}
