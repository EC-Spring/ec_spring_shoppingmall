package com.example.ec_spring_shoppingmall.domain.image.exception;

import com.example.ec_spring_shoppingmall.global.error.exception.EntityNotFoundException;

/**
 * @Author: kbs
 */
public class ImageNotFoundException extends EntityNotFoundException {
    public ImageNotFoundException() {
        super("이미지를 찾을 수 없습니다.");
    }
}