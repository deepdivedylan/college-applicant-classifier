package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;

import java.time.LocalDate;
import java.time.Period;

public class Felony implements ApplicationField<LocalDate> {
    private LocalDate date;

    public Felony(LocalDate newDate) {
        date = newDate;
    }

    @Override
    public String getName() {
        return "felony";
    }

    @Override
    public LocalDate getValue() {
        return date;
    }

    @Override
    public ThreeValueLogic accept() {
        return ThreeValueLogic.INDETERMINATE;
    }

    @Override
    public ThreeValueLogic reject() {
        LocalDate now = LocalDate.now();
        Period timeSince = Period.between(date, now);
        return ThreeValueLogic.fromBoolean(timeSince.getYears() < 5);
    }
}
