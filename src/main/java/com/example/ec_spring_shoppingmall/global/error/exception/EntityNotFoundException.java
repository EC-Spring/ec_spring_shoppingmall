package com.example.ec_spring_shoppingmall.global.error.exception;

/**
 * @Author: kbs
 */
public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(String message){
        super(message, ErrorCode.NOT_FOUND);
    }
}
