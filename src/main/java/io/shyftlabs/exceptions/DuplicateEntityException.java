package io.shyftlabs.exceptions;

public class DuplicateEntityException extends RuntimeException {
    public DuplicateEntityException(String errorMsg) {
        super(errorMsg);
    }
}
