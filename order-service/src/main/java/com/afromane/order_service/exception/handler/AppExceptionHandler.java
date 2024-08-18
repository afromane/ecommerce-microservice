package com.afromane.order_service.exception.handler;

import com.afromane.order_service.exception.EntityAlreadyExistsException;
import com.afromane.order_service.exception.EntityNotFoundException;
import com.afromane.order_service.exception.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {EntityNotFoundException.class})
    public @ResponseBody
    ResponseMessage handleException(EntityNotFoundException exception){
        return  ResponseMessage.builder()
                .code(404)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public @ResponseBody ResponseMessage handleException(EntityAlreadyExistsException exception){
        return  ResponseMessage.builder()
                .code(409)
                .message(exception.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(value = {RuntimeException.class})
    public @ResponseBody ResponseMessage handleException(RuntimeException exception){
        return  ResponseMessage.builder()
                .code(406)
                .message(exception.getMessage())
                .build();
    }



}
