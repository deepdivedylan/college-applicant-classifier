package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

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
    public ThreeValueLogic accept() {
        return ThreeValueLogic.INDETERMINATE;
    }

    @Override
    public ThreeValueLogic reject() {
        Pattern regex = Pattern.compile("^([A-Z][A-Za-z]*)(\\s[A-Z][A-Za-z]*)*$");
        return ThreeValueLogic.fromBoolean(!regex.matcher(name).matches());
    }
}
