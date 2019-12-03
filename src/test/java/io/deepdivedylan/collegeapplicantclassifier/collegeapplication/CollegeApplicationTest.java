package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules.InState;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ApplicationStatus;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.GpaField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTest;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTestScoreField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollegeApplicationTest {
    private CollegeApplication collegeApplication;

    @BeforeEach
    public void setUp() {
        collegeApplication = new CollegeApplication();
    }

    @Test
    public void testEmptyApplication() {
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.NEEDS_REVIEW);
    }

    @Test
    public void testInstantAcceptHighGpa() {
        collegeApplication.addField(new Gpa(new GpaField(4.7, 5.0)));
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.INSTANT_ACCEPT);
    }

    @Test
    public void testInstantAcceptYoungInState() {
        Age age = new Age(18);
        State state = new State("CA");
        collegeApplication.addField(age);
        collegeApplication.addField(state);
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.NEEDS_REVIEW);
        collegeApplication.addRule(new InState(age, state));
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.INSTANT_ACCEPT);
    }

    @Test
    public void testCompleteApplicationThatShouldAccept() {
        Age age = new Age(22);
        State state = new State("CA");
        Name name = new Name("Kathryn Janeway");
        Gpa gpa = new Gpa(new GpaField(4.8, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.SAT, 8472));

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.INSTANT_ACCEPT);
        collegeApplication.addRule(new InState(age, state));
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.INSTANT_ACCEPT);
    }

    @Test
    public void testCompleteApplicationThatShouldReject() {
        Age age = new Age(42);
        State state = new State("FR");
        Name name = new Name("Jean-Luc Picard");
        Gpa gpa = new Gpa(new GpaField(4.6, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.SAT, 1701));

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.INSTANT_REJECT);
    }

    @Test
    public void testCompleteApplicationThatShouldNeedReview() {
        Age age = new Age(36);
        State state = new State("IA");
        Name name = new Name("James Tiberius Kirk");
        Gpa gpa = new Gpa(new GpaField(4.2, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.ACT, 25));

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.NEEDS_REVIEW);
        collegeApplication.addRule(new InState(age, state));
        assertEquals(collegeApplication.getStatus(), ApplicationStatus.NEEDS_REVIEW);
    }
}
