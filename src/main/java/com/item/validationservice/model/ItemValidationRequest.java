package com.item.validationservice.model;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class ItemValidationRequest {
    private String siteId;
    private String categoryId;
    private String title;
    private ItemCondition condition;
    private BigDecimal price;
    private int quantity;
    private List<String> imageURLs;

    private List<String> itemSpecifics;
    private String description;
}
