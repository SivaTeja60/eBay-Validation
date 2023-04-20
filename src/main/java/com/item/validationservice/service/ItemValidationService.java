package com.item.validationservice.service;

import com.item.validationservice.exception.ItemValidationException;
import com.item.validationservice.handler.*;
import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.model.ItemValidationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemValidationService {
    private BaseItemValidationHandler validationHandler;

    public ItemValidationService(BaseItemValidationHandler validationHandler) {
        this.validationHandler = validationHandler;
    }

    public ItemValidationResponse validate(ItemValidationRequest item) {
        ItemValidationResponse response = new ItemValidationResponse();
        List<String> errors = new ArrayList<>();
        try {
            errors = validationHandler.validate(item);
        } catch (ItemValidationException e) {
            errors.add(e.getMessage());
        }
        response.setErrors(errors);
        response.setValid(errors.isEmpty());
        return response;
    }
}


