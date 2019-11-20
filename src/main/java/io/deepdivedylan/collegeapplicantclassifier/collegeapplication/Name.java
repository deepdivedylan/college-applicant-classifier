package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import java.util.regex.Pattern;

public class Name implements ApplicationField<String> {
    private String name;

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public void setValue(String newValue) {
        name = newValue;
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public boolean accept() {
        Pattern regex = Pattern.compile("^([A-Z][A-Za-z]*)(\\s[A-Z][A-Za-z]*)*$");
        return regex.matcher(name).matches();
    }

    @Override
    public boolean reject() {
        return false;
    }
}
