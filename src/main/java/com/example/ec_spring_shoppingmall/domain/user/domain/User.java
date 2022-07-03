package com.example.ec_spring_shoppingmall.domain.user.domain;

/**
 * @Author: kbs
 */

import com.example.ec_spring_shoppingmall.domain.model.BaseTimeEntity;
import com.example.ec_spring_shoppingmall.domain.order.domain.DeliveryOrder;
import com.example.ec_spring_shoppingmall.domain.orderedProduct.domain.OrderedProduct;
import com.example.ec_spring_shoppingmall.domain.user.constant.RoleType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "point", nullable = false)
    private String point;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "nick_name", nullable = false)
    private String nickName;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> cart;

    @OneToMany(mappedBy = "userId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeliveryOrder> deliveryOrders;

//    @OneToMany(mappedBy = "user")
//    private List<Address> addresses;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Coupon> coupons;

    @Builder
    User(String email, String image, String nickName) {
        this.email = email;
        this.image = image;
        this.nickName = nickName;
        this.role = RoleType.USER;
    }
}
