package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import java.time.LocalDate;
import java.time.Period;

public class Felony implements ApplicationField<LocalDate> {
    private LocalDate date;

    @Override
    public String getName() {
        return "felony";
    }

    @Override
    public void setValue(LocalDate newValue) {
        date = newValue;
    }

    @Override
    public LocalDate getValue() {
        return date;
    }

    @Override
    public boolean accept() {
        return true;
    }

    @Override
    public boolean reject() {
        LocalDate now = LocalDate.now();
        Period timeSince = Period.between(date, now);
        return timeSince.getYears() < 5;
    }
}
