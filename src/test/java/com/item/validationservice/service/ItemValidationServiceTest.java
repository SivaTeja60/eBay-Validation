package com.item.validationservice.service;

import com.item.validationservice.exception.ItemValidationException;
import com.item.validationservice.handler.BaseItemValidationHandler;
import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.model.ItemValidationResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemValidationServiceTest {
    private static BaseItemValidationHandler validationHandler;
    private static ItemValidationService itemValidationService;

    @BeforeAll
    public static void setUp() {
        validationHandler = mock(BaseItemValidationHandler.class);
        itemValidationService = new ItemValidationService(validationHandler);
    }

    @Test
    public void testValidate_validRequest() throws ItemValidationException {
        // Arrange
        ItemValidationRequest request = new ItemValidationRequest();
        when(validationHandler.validate(request)).thenReturn(new ArrayList<>());
        // Act
        ItemValidationResponse response = itemValidationService.validate(request);
        // Assert
        assertEquals(true, response.isValid());
        assertEquals(0, response.getErrors().size());
    }

    @Test
    public void testValidate_invalidRequest() throws ItemValidationException {
        // Arrange
        ItemValidationRequest request = new ItemValidationRequest();
        List<String> errors = new ArrayList<>();
        errors.add("Invalid site ID");
        when(validationHandler.validate(request)).thenReturn(errors);
        // Act
        ItemValidationResponse response = itemValidationService.validate(request);
        // Assert
        assertEquals(false, response.isValid());
        assertEquals(errors, response.getErrors());
    }
}
