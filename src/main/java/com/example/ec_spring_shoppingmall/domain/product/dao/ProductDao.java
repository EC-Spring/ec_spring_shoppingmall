package com.example.ec_spring_shoppingmall.domain.product.dao;

import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
        //.orElseThrow();
        return product.get();
    }

    public List<Product> findAllByPriceBetween(final int low,final int high){
        final List<Product> products = productRepository.findAllByPriceBetween(low, high);

        if(products.size()==0)System.out.println("가격 내의 product가 존재하지 않습니다.");

        return products;
    }

    public Product save(final ProductRequest productRequest){
        Product product = productRequest.toEntity();
        productRepository.save(product);
//        CommonUtil.saveIfNullId(productRequest.getId(), productRepository, productRequest.toEntity());
        return product;
    }

    public Product update(final ProductRequest productRequest){
        Product product = productRepository.findById(productRequest.getId())
                .orElseThrow();
        product.setName(productRequest.getName());
        product.setBrand(productRequest.getBrand());
        product.setInfo(productRequest.getInfo());
        product.setPrice(productRequest.getPrice());
        product.setPartNumber(productRequest.getPartNumber());
        product.setThumbnailId(productRequest.getThumbnailId());
        productRepository.save(product);

        return product;
    }

    public void delete(final Long productId){
        productRepository.deleteById(productId);
    }
}
