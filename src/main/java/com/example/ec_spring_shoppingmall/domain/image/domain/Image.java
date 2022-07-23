package com.example.ec_spring_shoppingmall.domain.image.domain;

/**
 * @Author: kbs
 */

import com.example.ec_spring_shoppingmall.domain.model.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="url")
    private String url;

    @Builder
    public Image(String url) {
        this.url = url;
    }
}
