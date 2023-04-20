package com.item.validationservice.handler;

import com.item.validationservice.model.ItemCondition;
import com.item.validationservice.model.ItemValidationRequest;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public class SiteIdValidator extends BaseItemValidationHandler {
    public static final String SITE_ID_IS_REQUIRED = "Site Id is required";
    @Override
    public List<String> validate(ItemValidationRequest item) {
        List<String> errors = new ArrayList<>();
        if (Optional.ofNullable(item.getSiteId()).isEmpty()) {
            errors.add(SITE_ID_IS_REQUIRED);
            log.error(SITE_ID_IS_REQUIRED);
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}

