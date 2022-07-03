package com.example.ec_spring_shoppingmall.domain.size.domain;

import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: kbs
 */

@Getter
@NoArgsConstructor
@Entity
@Table(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "productsize")
    private String productSize;

    @Column(name = "stock")
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Builder
    public Size(String productSize, Integer stock, Product productId) {
        this.productSize = productSize;
        this.stock = stock;
        this.productId = productId;
    }
}
