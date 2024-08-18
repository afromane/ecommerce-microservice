package com.afromane.product_service.exception;

public class EntityAlreadyExistsException  extends  RuntimeException{
    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
