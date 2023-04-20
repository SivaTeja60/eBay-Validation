package com.item.validationservice.exception;

import java.util.List;

public class ItemValidationException extends RuntimeException {

    private final List<String> errors;

    public ItemValidationException(String error) {
        this.errors = getErrors();
        this.errors.add(error);
    }

    public List<String> getErrors() {
        return errors;
    }
}
