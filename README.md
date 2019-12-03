# College Applicant Qualifier
This is a SpringBoot based application that evaluates candidates for application to Starfleet Academy. Each candidate must submit:
* age
* felonies committed, if any
* GPA
* name
* standardize test score(s)
* state

The application will evaluate each candidate based on these fields and return one of three statuses:
* instant accept: all criteria are met and the candidate should be admitted
* instant reject: one or more "critical" criterion have been encountered and the candidate should be rejected
* needs review: candidate has neither been accepted or rejected and should be manually evaluated

# Running the app

To execute the app, simply build with gradle and start the Docker container:
```
$ ./gradlew build
$ ./gradlew docker
$ docker run -p 8080:8080 io.deepdivedylan.collegeapplicantclassifier
```

Now visit [http://localhost:8080](http://localhost:8080) in your browser to see the college applications.

# Adding Fields & Rules
## Three Value Logic
The fields and rules were designed to be extensible and generic to suit evolving needs. The fields and rules are based on three value logic that is essentially a boolean with an extra value:
* `false`: the field or rule fails
* `true`: the field or rule succeeds
* `indeterminate`: the field or rule neither fails nor succeeds, proceed to next field or rule

Each field or rule conform to normal boolean logic (AND, OR) where an `indeterminate` value simply returns the value of the other operand (e.g., T OR I = T, F AND I = F). The indeterminate value is used to express where the field or rule does not have sufficient information to make a positive evaluation.

## Adding Fields
To add a field, implement the `ApplicationField` contract with the following methods:
* name: field name as a String
* value: value of the field, as any date type
* accept: boolean expression as to whether the application should qualify to be an instant accept, or indeterminate if no criteria applies
* reject: boolean expression as to whether the application should qualify to be an instant reject, or indeterminate if no criteria applies

As each field is added to the college application, accept and reject criteria are continuously applied.

## Adding Rules
Rules are similar to fields, except they encapsulate logic that involves two fields. For instance, a rule could express "if GPA is greater than 3.0, require the ACT to be greater than or equal to 28". Rules, like fields, are continuously applied to the college application as rules are added. The `Rule` contract requires:
* left: the "left" side of the rule
* right: the "right" side of the rule
* accept: boolean expression as to whether the application should qualify to be an instant accept, or indeterminate if no criteria applies
* reject: boolean expression as to whether the application should qualify to be an instant reject, or indeterminate if no criteria applies

The left and right sides of the rule simply identify what type of field the rule is applying to. The accept and reject criteria are the exact same construct as fields.
