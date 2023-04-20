package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class QuantityValidator extends BaseItemValidationHandler {
    public static final String QUANTITY_GREATHER_THAN_ZERO = "Quantity should be greater than zero";;
    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("QuantityValidator {}", item.getQuantity());
        List<String> errors = new ArrayList<>();
        if (item.getQuantity() < 0) {
            errors.add(QUANTITY_GREATHER_THAN_ZERO);
            log.error(QUANTITY_GREATHER_THAN_ZERO);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}

