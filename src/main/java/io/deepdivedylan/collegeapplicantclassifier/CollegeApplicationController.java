package io.deepdivedylan.collegeapplicantclassifier;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.*;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules.InState;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.GpaField;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTest;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.StandardizedTestScoreField;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class CollegeApplicationController {
    @GetMapping("/")
    public String home(Model model) {
        List<CollegeApplication> collegeApplications = new LinkedList<CollegeApplication>();
        collegeApplications.add(getJamesTiberiusKirk());
        collegeApplications.add(getJeanLucPicard());
        collegeApplications.add(getKathrynJaneway());

        model.addAttribute("collegeApplications", collegeApplications);
        return "index";
    }

    public CollegeApplication getKathrynJaneway() {
        Age age = new Age(22);
        State state = new State("CA");
        Name name = new Name("Kathryn Janeway");
        Gpa gpa = new Gpa(new GpaField(4.8, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.SAT, 8472));
        CollegeApplication collegeApplication = new CollegeApplication();

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        collegeApplication.addRule(new InState(age, state));
        return collegeApplication;
    }

    public CollegeApplication getJeanLucPicard() {
        Age age = new Age(42);
        State state = new State("FR");
        Name name = new Name("Jean-Luc Picard");
        Gpa gpa = new Gpa(new GpaField(4.6, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.SAT, 1701));
        CollegeApplication collegeApplication = new CollegeApplication();

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        return collegeApplication;
    }

    public CollegeApplication getJamesTiberiusKirk() {
        Age age = new Age(36);
        State state = new State("IA");
        Name name = new Name("James Tiberius Kirk");
        Gpa gpa = new Gpa(new GpaField(4.2, 5.0));
        StandardizedTestScore standardizedTestScore = new StandardizedTestScore(new StandardizedTestScoreField(StandardizedTest.ACT, 25));
        CollegeApplication collegeApplication = new CollegeApplication();

        collegeApplication.addField(age);
        collegeApplication.addField(state);
        collegeApplication.addField(name);
        collegeApplication.addField(gpa);
        collegeApplication.addField(standardizedTestScore);
        collegeApplication.addRule(new InState(age, state));
        return collegeApplication;
    }
}
