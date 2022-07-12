package com.example.ec_spring_shoppingmall.domain.product.domain;

/**
 * @Author: kbs
 */

import com.example.ec_spring_shoppingmall.domain.image.domain.Image;
import com.example.ec_spring_shoppingmall.domain.model.BaseTimeEntity;
import com.example.ec_spring_shoppingmall.domain.size.domain.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "brand", nullable = false)
    private String brand;

    @Setter
    @Column(name = "partNumber", nullable = false)
    private String partNumber;

    @Setter
    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "views", nullable = false)
    private Integer views;

    @Lob
    @Setter
    @Column(name = "info", nullable = false)
    private String info;

    @OneToOne
    @Setter
    @JoinColumn(name = "thumbnail_id")
    private Image thumbnailId;

    @OneToMany(mappedBy = "productId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Size> sizes;

//    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comments> comments;

    @Builder
    public Product(String name, String brand, String partNumber, Integer price,
                   String info, Image thumbnailId) {

        this.name = name;
        this.brand = brand;
        this.partNumber = partNumber;
        this.price = price;
        this.views = 0;
        this.info = info;
        this.thumbnailId = thumbnailId;
    }
}
