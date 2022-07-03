package com.example.ec_spring_shoppingmall.domain.order.domain;

/**
 * @Author: kbs
 */

import com.example.ec_spring_shoppingmall.domain.model.BaseTimeEntity;
import com.example.ec_spring_shoppingmall.domain.orderedProduct.domain.OrderedProduct;
import com.example.ec_spring_shoppingmall.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "delivery_order")
public class DeliveryOrder extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true)
    private Integer orderNumber;

    @Column(name = "cost", nullable = false)
    private Integer cost;
//
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany(mappedBy = "deliveryOrderId",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderedProduct> orderedProducts;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Address address;

    @Builder

    public DeliveryOrder(Integer orderNumber, Integer cost) {
        this.orderNumber = orderNumber;
        this.cost = cost;
    }
}
