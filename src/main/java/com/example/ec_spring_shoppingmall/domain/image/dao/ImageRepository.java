package com.example.ec_spring_shoppingmall.domain.image.dao;

import com.example.ec_spring_shoppingmall.domain.image.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: kbs
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByUrl(String url);
    Optional<Image> findById(Long id);
}
