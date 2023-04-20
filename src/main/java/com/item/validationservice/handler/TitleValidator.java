package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class TitleValidator extends BaseItemValidationHandler {
    public static final String ITEM_TITLE_CANNOT_BE_EMPTY = "Item Title cannot be empty";
    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("TitleValidator Validator called");
        List<String> errors = new ArrayList<>();
        if (Optional.ofNullable(item.getTitle()).isEmpty()) {
            errors.add(ITEM_TITLE_CANNOT_BE_EMPTY);
            log.error(ITEM_TITLE_CANNOT_BE_EMPTY);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}
