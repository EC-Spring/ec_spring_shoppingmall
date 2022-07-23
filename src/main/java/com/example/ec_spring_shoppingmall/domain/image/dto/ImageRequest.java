package com.example.ec_spring_shoppingmall.domain.image.dto;

import com.example.ec_spring_shoppingmall.domain.image.domain.Image;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: kbs
 */
@Getter
@Builder
public class ImageRequest {

    private final String url;

    private final MultipartFile file;

    public Image toEntity() {
        return Image.builder()
                .url(url)
                .build();
    }
}