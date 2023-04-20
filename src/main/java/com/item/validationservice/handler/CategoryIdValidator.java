package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class CategoryIdValidator extends BaseItemValidationHandler {
    public static final String CATEGORY_ID_SHOULD_BE_PRESENT = "Category ID should be present";
    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("CategoryIdValidator {}", item.getCategoryId());
        List<String> errors = new ArrayList<>();

        if (Optional.ofNullable(item.getCategoryId()).isEmpty()) {
            errors.add(CATEGORY_ID_SHOULD_BE_PRESENT);
            log.error(CATEGORY_ID_SHOULD_BE_PRESENT);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}
