package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class PriceValidator extends BaseItemValidationHandler {
    public static final String ITEM_PRICE_CANNOT_BE_EMPTY = "Item Price cannot be empty";
    public static final String ITEM_PRICE_CANNOT_BE_NEGATIVE = "Item Price cannot be negative";

    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("PriceValidator {}", item.getPrice());
        List<String> errors = new ArrayList<>();
        if (Optional.ofNullable(item.getPrice()).isEmpty()) {
            errors.add(ITEM_PRICE_CANNOT_BE_EMPTY);
            log.error(ITEM_PRICE_CANNOT_BE_EMPTY);
        }
        else if(item.getPrice().compareTo(BigDecimal.ZERO) < 0){
            errors.add(ITEM_PRICE_CANNOT_BE_NEGATIVE);
            log.error(ITEM_PRICE_CANNOT_BE_NEGATIVE);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}
