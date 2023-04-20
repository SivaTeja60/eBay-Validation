package com.item.validationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ItemValidationResponse {
    public boolean valid;
    public List<String> errors;
}