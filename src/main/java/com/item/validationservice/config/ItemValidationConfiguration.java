package com.item.validationservice.config;

import com.item.validationservice.handler.*;
import com.item.validationservice.service.ItemSpecificNormalizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemValidationConfiguration {
    @Bean
    public BaseItemValidationHandler validationHandler(ItemSpecificNormalizer itemSpecificNormalizer) {
        BaseItemValidationHandler conditionalValidator = new ConditionBasedValidationHandler();
        BaseItemValidationHandler siteIdValidator = new SiteIdValidator();
        BaseItemValidationHandler categoryIdValidator = new CategoryIdValidator();
        BaseItemValidationHandler quantityValidator = new QuantityValidator();
        BaseItemValidationHandler imageUrlValidator = new ImageUrlValidator();
        BaseItemValidationHandler titleValidator = new TitleValidator();
        BaseItemValidationHandler descriptionValidator = new DescriptionValidator();
        BaseItemValidationHandler priceValidator = new PriceValidator();
        BaseItemValidationHandler conditionValidator = new ConditionValidator();
        BaseItemValidationHandler itemSpecificsValidator = new ItemSpecificsValidator(itemSpecificNormalizer);

        conditionalValidator.setNext(siteIdValidator);
        siteIdValidator.setNext(categoryIdValidator);
        categoryIdValidator.setNext(quantityValidator);
        quantityValidator.setNext(imageUrlValidator);
        imageUrlValidator.setNext(titleValidator);
        titleValidator.setNext(descriptionValidator);
        descriptionValidator.setNext(priceValidator);
        priceValidator.setNext(conditionValidator);
        conditionValidator.setNext(itemSpecificsValidator);

        return conditionalValidator;
    }
}

