package com.engeto.springBootProject.model.response;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse extends ErrorResponse{

    private List<Violation> violations = new ArrayList<>();

    public ValidationErrorResponse() {
        super(HttpStatus.BAD_REQUEST.value(), "Validation error.");
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }
}
