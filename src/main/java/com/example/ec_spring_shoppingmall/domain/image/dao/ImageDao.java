package com.example.ec_spring_shoppingmall.domain.image.dao;

import com.example.ec_spring_shoppingmall.domain.image.domain.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Author: kbs
 */

@Repository
@RequiredArgsConstructor
public class ImageDao {
    private final ImageRepository imageRepository;

    public Image save(String path){
        Image image = Image.builder().url(path).build();
        imageRepository.save(image);
        return image;
    }
}
