package com.afroane.inventory_service.exception;

public class EntityAlreadyExistsException  extends  RuntimeException{
    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
