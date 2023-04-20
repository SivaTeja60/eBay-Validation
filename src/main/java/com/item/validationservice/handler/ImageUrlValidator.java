package com.item.validationservice.handler;

import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ImageUrlValidator extends BaseItemValidationHandler {

    public static final String IMAGE_URL_S_CANNOT_BE_EMPTY = "Image URL's cannot be empty";

    @Override
    public List<String> validate(ItemValidationRequest item) {
        log.info("ImageUrlValidator {}", item.getImageURLs());
        List<String> errors = new ArrayList<>();
        if (Optional.ofNullable(item.getImageURLs()).isEmpty()) {
            errors.add(IMAGE_URL_S_CANNOT_BE_EMPTY);
            log.error(IMAGE_URL_S_CANNOT_BE_EMPTY);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}

