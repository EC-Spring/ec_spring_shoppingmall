package com.example.ec_spring_shoppingmall.domain.product.api;

import com.example.ec_spring_shoppingmall.domain.product.application.ProductService;
import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.product.dto.ProductRequest;
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
    public ResponseEntity<Void> saveProduct(@RequestBody @Valid ProductRequest product){
        productService.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid ProductRequest product){
        productService.update(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/between")
    public ResponseEntity<List<Product>> getAllProductByPriceBetween(
            @RequestParam("low")int low, @RequestParam("high")int high
    ) {
        return ResponseEntity.ok().body(productService.findAllByPriceBetween(low, high));
    }


    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestParam("id")Long id){
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}
