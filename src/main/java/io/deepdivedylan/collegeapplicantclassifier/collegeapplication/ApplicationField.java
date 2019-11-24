package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

public interface ApplicationField<T> {
    public String getName();
    public T getValue();
    public boolean accept();
    public boolean reject();
}
