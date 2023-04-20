package com.item.validationservice.handler;

import com.item.validationservice.exception.ItemValidationException;
import com.item.validationservice.model.ItemCondition;
import com.item.validationservice.model.ItemValidationRequest;

import java.util.Collections;
import java.util.List;

public class ConditionBasedValidationHandler extends BaseItemValidationHandler {

    @Override
    public List<String> validate(ItemValidationRequest item) throws ItemValidationException {
        if (item.getCondition() == ItemCondition.USED) {
            return Collections.emptyList();
        }
        return super.validate(item);
    }
}

