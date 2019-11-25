package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import java.util.regex.Pattern;

public class Name implements ApplicationField<String> {
    private String name;

    public Name(String newName) {
        name = newName;
    }

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public String getValue() {
        return name;
    }

    @Override
    public boolean accept() {
        return true;
    }

    @Override
    public boolean reject() {
        Pattern regex = Pattern.compile("^([A-Z][A-Za-z]*)(\\s[A-Z][A-Za-z]*)*$");
        return !regex.matcher(name).matches();
    }
}
