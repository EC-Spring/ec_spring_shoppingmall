package com.example.ec_spring_shoppingmall.domain.product.dao;

import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: kbs
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    Optional<Product> findByBrand(String brand);
    Optional<Product> findByPartNumber(String partNumber);
    List<Product> findAllByPriceBetween(int start, int end);

}
