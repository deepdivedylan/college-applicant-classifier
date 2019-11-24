package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(felony.accept());
    }

    @Test
    public void testRejectOldFelonies() {
        LocalDate fiveYearsBack = now.minusYears(5);
        Felony oldFelony = new Felony(fiveYearsBack);
        assertTrue(felony.reject());
        assertFalse(oldFelony.reject());
    }
}
