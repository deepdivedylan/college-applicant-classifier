package io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types;

public enum ThreeValueLogic {
    FALSE(0), TRUE(1), INDETERMINATE(2);

    private final int value;

    private ThreeValueLogic(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }

    public static ThreeValueLogic and(ThreeValueLogic left, ThreeValueLogic right) {
        if (left == ThreeValueLogic.INDETERMINATE) {
            return right;
        }
        if (right == ThreeValueLogic.INDETERMINATE) {
            return left;
        }
        return ThreeValueLogic.fromBoolean(ThreeValueLogic.toBoolean(left) && ThreeValueLogic.toBoolean(right));
    }

    public static ThreeValueLogic or(ThreeValueLogic left, ThreeValueLogic right) {
        if (left == ThreeValueLogic.INDETERMINATE) {
            return right;
        }
        if (right == ThreeValueLogic.INDETERMINATE) {
            return left;
        }
        return ThreeValueLogic.fromBoolean(ThreeValueLogic.toBoolean(left) || ThreeValueLogic.toBoolean(right));
    }

    public static ThreeValueLogic fromBoolean(boolean value) {
        return value ? ThreeValueLogic.TRUE : ThreeValueLogic.FALSE;
    }

    public static boolean toBoolean(ThreeValueLogic value) throws IllegalArgumentException {
        if (value == ThreeValueLogic.TRUE) {
            return true;
        }
        if (value == ThreeValueLogic.FALSE) {
            return false;
        }
        throw new IllegalArgumentException("indeterminate values are not boolean");
    }

}
