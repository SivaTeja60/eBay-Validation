package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DescriptionValidator extends BaseItemValidationHandler {
    public static final String ITEM_DESCRIPTION_CANNOT_BE_EMPTY = "Item Description cannot be empty";
    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("DescriptionValidator {}", item.getDescription());
        List<String> errors = new ArrayList<>();
        if (Optional.ofNullable(item.getDescription()).isEmpty()) {
            errors.add(ITEM_DESCRIPTION_CANNOT_BE_EMPTY);
            log.error(ITEM_DESCRIPTION_CANNOT_BE_EMPTY);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}

