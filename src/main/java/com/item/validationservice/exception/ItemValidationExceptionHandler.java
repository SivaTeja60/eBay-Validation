package com.item.validationservice.exception;

import com.item.validationservice.model.ItemValidationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ItemValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ItemValidationException.class)
    protected ResponseEntity<Object> handleInvalidRequest(ItemValidationException ex) {
        ItemValidationResponse response = new ItemValidationResponse();
        response.setValid(false);
        response.setErrors(ex.getErrors());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}

