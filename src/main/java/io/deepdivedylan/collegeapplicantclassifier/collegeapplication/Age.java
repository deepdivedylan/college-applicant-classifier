package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

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
    public boolean accept() {
        return true;
    }

    @Override
    public boolean reject() {
        return age < 0;
    }
}
