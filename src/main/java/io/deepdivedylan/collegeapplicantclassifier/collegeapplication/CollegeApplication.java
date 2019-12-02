package io.deepdivedylan.collegeapplicantclassifier.collegeapplication;

import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.rules.Rule;
import io.deepdivedylan.collegeapplicantclassifier.collegeapplication.types.ApplicationStatus;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class CollegeApplication {
    private UUID id;
    private LocalDate applicationDate;
    private List<ApplicationField> fields;
    private List<Rule> rules;
    private ApplicationStatus status;

    public CollegeApplication() {
        id = UUID.randomUUID();
        applicationDate = LocalDate.now();
        fields = new LinkedList<ApplicationField>();
        rules = new LinkedList<Rule>();
        status = ApplicationStatus.NEEDS_REVIEW;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public List<ApplicationField> getFields() {
        return fields;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void addField(ApplicationField field) {
        fields.add(field);

        boolean accept = true;
        boolean reject = false;
        for (ApplicationField applicationField : fields) {
            accept = accept && applicationField.accept();
            reject = reject || applicationField.reject();
        }
        if (reject) {
            status = ApplicationStatus.INSTANT_REJECT;
        } else if (accept) {
            status = ApplicationStatus.INSTANT_ACCEPT;
        }
    }

    public void addRule(Rule rule) {
        ApplicationField left = null;
        ApplicationField right = null;
        for (ApplicationField applicationField : fields) {
            if (rule.getLeft().getClass().getName().equals(applicationField.getClass().getName())) {
                left = applicationField;
            }
            if (rule.getRight().getClass().getName().equals(applicationField.getClass().getName())) {
                right = applicationField;
            }
        }

        if (left != null && right != null) {
            rules.add(rule);
            if (rule.reject()) {
                status = ApplicationStatus.INSTANT_REJECT;
            } else if (rule.accept()) {
                status = ApplicationStatus.INSTANT_ACCEPT;
            }
        }
    }
}
