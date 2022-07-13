package com.example.ec_spring_shoppingmall.domain.product.api;

import com.example.ec_spring_shoppingmall.domain.product.application.ProductService;
import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductRequest;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: kbs
 */

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody @Valid ProductRequest product){
        return ResponseEntity.ok().body(productService.save(product));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody @Valid ProductRequest product){
        return ResponseEntity.ok().body(productService.update(product));
    }

    @GetMapping("/between")
    public ResponseEntity<List<ProductResponse>> getAllProductByPriceBetween(
            @RequestParam("low")int low, @RequestParam("high")int high
    ) {
        return ResponseEntity.ok().body(productService.findAllByPriceBetween(low, high));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ProductResponse> deleteProduct(@RequestParam("id")Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
