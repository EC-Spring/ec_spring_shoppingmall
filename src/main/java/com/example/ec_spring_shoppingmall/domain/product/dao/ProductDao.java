package com.example.ec_spring_shoppingmall.domain.product.dao;

import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductRequest;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductResponse;
import com.example.ec_spring_shoppingmall.domain.product.exception.ProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @Author: kbs
 */
@Repository
@RequiredArgsConstructor
public class ProductDao {

    private final ProductRepository productRepository;

    public Product findById(final long id) {
        //에러 handler 추가해야함.
        final Optional<Product> product = productRepository.findById(id);
        product.orElseThrow(() -> new ProductNotFoundException(id));
        return product.get();
    }

    public List<ProductResponse> findAllByPriceBetween(final int low,final int high){
        final List<Product> products = productRepository.findAllByPriceBetween(low, high);
        List<ProductResponse> productsToShow = new ArrayList<>();

        //JPA 통해서 그냥 DTO직접받고싶음.
        for(Product product : products)
            productsToShow.add(ProductResponse.from(product));

        return productsToShow;
    }

    public Product save(final ProductRequest productRequest){
        Product product = productRequest.toEntity();
        productRepository.save(product);
        return product;
    }

    public Product update(final ProductRequest productRequest){
        Optional<Product> product = productRepository.findById(productRequest.getId());
        product.orElseThrow(() -> new ProductNotFoundException(productRequest.getId()));
        Product toUpdate = product.get();

        toUpdate.setName(productRequest.getName());
        toUpdate.setBrand(productRequest.getBrand());
        toUpdate.setInfo(productRequest.getInfo());
        toUpdate.setPrice(productRequest.getPrice());
        toUpdate.setThumbnailUrl(productRequest.getThumbnailUrl());
        productRepository.save(toUpdate);

        return toUpdate;
    }

    public void delete(final Long productId){
        productRepository.deleteById(productId);
    }
}
