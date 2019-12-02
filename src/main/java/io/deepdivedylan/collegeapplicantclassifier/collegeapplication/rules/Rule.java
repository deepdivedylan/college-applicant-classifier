package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules;

public interface Rule<L, R> {
    public L getLeft();
    public R getRight();
    public boolean accept();
    public boolean reject();
}
