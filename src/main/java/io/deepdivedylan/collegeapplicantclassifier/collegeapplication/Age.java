package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

public class Age implements ApplicationField<Integer> {
    private Integer age;

    public Age(Integer newValue) {
        setValue(newValue);
    }

    @Override
    public String getName() {
        return "age";
    }

    @Override
    public void setValue(Integer newValue) {
        age = newValue;
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
