package com.example.ec_spring_shoppingmall.domain.product.exception;

import com.example.ec_spring_shoppingmall.global.error.exception.EntityNotFoundException;

/**
 * @Author: kbs
 */
public class ProductNotFoundException extends EntityNotFoundException {

    public ProductNotFoundException(Long target){
        super("product id " + target + " is not Found");
    }

}
