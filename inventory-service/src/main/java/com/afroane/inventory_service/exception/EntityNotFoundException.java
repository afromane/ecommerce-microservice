package com.afroane.inventory_service.exception;

public class EntityNotFoundException extends  RuntimeException{
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
