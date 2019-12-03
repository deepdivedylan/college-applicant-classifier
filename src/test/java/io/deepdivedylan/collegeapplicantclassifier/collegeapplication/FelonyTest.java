package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ThreeValueLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelonyTest {
    private Felony felony;
    private LocalDate now;

    @BeforeEach
    public void setUp() {
        now = LocalDate.now();
        felony = new Felony(now);
    }

    @Test
    public void testField() {
        assertEquals(felony.getName(), "felony");
        assertEquals(felony.getValue(), now);
    }

    @Test
    public void testAlwaysAccept() {
        assertEquals(felony.accept(), ThreeValueLogic.INDETERMINATE);
    }

    @Test
    public void testRejectOldFelonies() {
        LocalDate fiveYearsBack = now.minusYears(5);
        Felony oldFelony = new Felony(fiveYearsBack);
        assertEquals(felony.reject(), ThreeValueLogic.TRUE);
        assertEquals(oldFelony.reject(), ThreeValueLogic.FALSE);
    }
}
