package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

public class Age implements ApplicationField<Integer> {
    private Integer age;

    public Age(Integer newAge) {
        age = newAge;
    }

    @Override
    public String getName() {
        return "age";
    }

    @Override
    public Integer getValue() {
        return age;
    }

    @Override
    public ThreeValueLogic accept() {
        return ThreeValueLogic.INDETERMINATE;
    }

    @Override
    public ThreeValueLogic reject() {
        return ThreeValueLogic.fromBoolean(age < 0);
    }
}
