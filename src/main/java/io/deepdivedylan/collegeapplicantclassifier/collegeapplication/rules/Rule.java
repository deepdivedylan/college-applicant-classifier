package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

public interface Rule<L, R> {
    public L getLeft();
    public R getRight();
    public ThreeValueLogic accept();
    public ThreeValueLogic reject();
}
