package com.item.validationservice.handler;

import com.item.validationservice.exception.ItemValidationException;
import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.service.ItemSpecificNormalizer;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ItemSpecificsValidator extends BaseItemValidationHandler {
    private ItemSpecificNormalizer itemSpecificNormalizer;

    public ItemSpecificsValidator(ItemSpecificNormalizer itemSpecificNormalizer) {
        this.itemSpecificNormalizer = itemSpecificNormalizer;
    }

    @Override
    public List<String> validate(ItemValidationRequest item) throws ItemValidationException {
        List<String> errors = new ArrayList<>();
        List<String> itemSpecifics = item.getItemSpecifics();
        if (itemSpecifics == null || itemSpecifics.isEmpty()) {
            errors.add("Item specifics are required");
            return errors;
        }
        for (String itemSpecific : itemSpecifics) {
            if (itemSpecific == null || itemSpecific.trim().isEmpty()) {
                errors.add("Item specific value cannot be null or empty");
            } else {
                try {
                    this.itemSpecificNormalizer.normalize(itemSpecific);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new ItemValidationException("Failed to normalize item specific value: " + e.getMessage());
                }
            }
        }
        if (nextValidator != null) {
            errors.addAll(nextValidator.validate(item));
        }
        return errors;
    }
}

