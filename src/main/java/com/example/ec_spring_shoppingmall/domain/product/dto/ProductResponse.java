package com.example.ec_spring_shoppingmall.domain.product.dto;

import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author: kbs
 */

@Getter
@Builder
public class ProductResponse {
    private final Long id;
    private final String name;
    private final String brand;
    private final Integer price;
    private final String thumbnailUrl;


    public static ProductResponse from(Product product) {
        if(product == null) return null;

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .thumbnailUrl(product.getThumbnailUrl())
                .build();
    }

}
