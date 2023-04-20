package com.item.validationservice.handler;

import com.item.validationservice.model.ItemCondition;
import com.item.validationservice.model.ItemValidationRequest;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseItemValidationHandler{
    protected BaseItemValidationHandler nextValidator;
    public void setNext(BaseItemValidationHandler nextValidator) {
        this.nextValidator = nextValidator;
    }
    public List<String> validate(ItemValidationRequest item) {
        List<String> errors = new ArrayList<>();
        if (shouldSkipValidation(item)) {
            return errors;
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
    protected boolean shouldSkipValidation(ItemValidationRequest request) {
        return request.getCondition()== ItemCondition.USED;
    }
}


