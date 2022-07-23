package com.example.ec_spring_shoppingmall.domain.product.application;

import com.example.ec_spring_shoppingmall.domain.product.dao.ProductDao;
import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductRequest;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: kbs
 */

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    public List<ProductResponse> findAllByPriceBetween(final int low, final int high){
        return productDao.findAllByPriceBetween(low, high);
    }

    public ProductResponse save(final ProductRequest productRequest){
        return ProductResponse.from(productDao.save(productRequest));
    }

    public void delete(final Long productId){
        productDao.delete(productId);
    }

    public ProductResponse update(ProductRequest productRequest) {
        return ProductResponse.from(productDao.update(productRequest));
    }
}
