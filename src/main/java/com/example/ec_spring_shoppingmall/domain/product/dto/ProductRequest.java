package com.example.ec_spring_shoppingmall.domain.product.dto;

import com.example.ec_spring_shoppingmall.domain.image.domain.Image;
import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.size.domain.Size;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author: kbs
 */
@Getter
@Builder
public class ProductRequest {

    private final Long id;

    @NotNull
    private final String name;
    @NotBlank(message="브랜드를 입력해주셔야 합니다.")
    private final String brand;
    @NotNull
    private final String info;
    @NotNull
    private final String partNumber;
    @NotNull
    private final Integer price;

    private final List<Size> sizes;

    private final Image thumbnailId;

    public static ProductRequest from(Product product) {
        if(product == null) return null;

        return ProductRequest.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .info(product.getInfo())
                .partNumber(product.getPartNumber())
                .price(product.getPrice())
                .sizes(product.getSizes())
                .thumbnailId(product.getThumbnailId())
                .build();
    }

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .brand(brand)
                .info(info)
                .partNumber(partNumber)
                .price(price)
                .thumbnailId(thumbnailId)
                .build();
    }

}
