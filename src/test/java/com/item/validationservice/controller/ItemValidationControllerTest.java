package com.item.validationservice.controller;

import com.item.validationservice.model.ItemCondition;
import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.model.ItemValidationResponse;
import com.item.validationservice.service.ItemValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.util.Collections;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ItemValidationControllerTest {
    @Mock
    private ItemValidationService itemValidationService;
    @InjectMocks
    private ItemValidationController itemValidationController;
    @Test
    public void testValidateItem() {
        // given
        ItemValidationRequest request = new ItemValidationRequest();
        request.setCategoryId("123");
        request.setSiteId("123");
        request.setTitle("testTitle");
        request.setCondition(ItemCondition.NEW);
        request.setPrice(BigDecimal.valueOf(100.0));
        request.setQuantity(1);

        ItemValidationResponse response = new ItemValidationResponse();
        response.setValid(true);
        response.setErrors(Collections.emptyList());

        when(itemValidationService.validate(request)).thenReturn(response);
        ResponseEntity<ItemValidationResponse> responseEntity = itemValidationController.validateItem(request);
        Assertions.assertEquals(responseEntity.getStatusCode().value(), 200);
    }

}


