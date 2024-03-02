package io.shyftlabs.responses;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private final String errorMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ValidationError> validationErrors;


    public ErrorResponse(String message) {
        this.errorMessage = message;
    }

    public void addValidationError(String field, String message) {
        if (validationErrors == null) {
            validationErrors = new ArrayList<>();
        }
        validationErrors.add(new ValidationError(field, message));
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }


    public static class ValidationError {
        private final String field;
        private final String message;


        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }

    }

}