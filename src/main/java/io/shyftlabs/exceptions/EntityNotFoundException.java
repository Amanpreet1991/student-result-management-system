package io.shyftlabs.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
