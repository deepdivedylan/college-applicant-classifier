package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

public interface ApplicationField<T> {
    public String getName();
    public T getValue();
    public ThreeValueLogic accept();
    public ThreeValueLogic reject();
}
