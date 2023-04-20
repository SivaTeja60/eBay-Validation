package com.item.validationservice.controller;

import com.item.validationservice.model.ItemValidationRequest;
import com.item.validationservice.model.ItemValidationResponse;
import com.item.validationservice.service.ItemValidationService;
import io.micrometer.observation.annotation.Observed;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@Slf4j
@Observed
public class ItemValidationController {
    private final ItemValidationService itemValidationService;

    @PostMapping(value = "/api/items/validate")
    public ResponseEntity<ItemValidationResponse> validateItem( @RequestBody ItemValidationRequest request) {

        return ResponseEntity.of(Optional.of(itemValidationService.validate(request)));
    }
}
