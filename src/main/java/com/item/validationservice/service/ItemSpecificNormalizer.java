package com.item.validationservice.service;

import org.springframework.stereotype.Component;

@Component
public class ItemSpecificNormalizer {

    public String normalize(String itemSpecific) throws InterruptedException {
        Thread.sleep(1000);
        return itemSpecific.substring(0, 1).toUpperCase() + itemSpecific.substring(1).toLowerCase();
    }

}

