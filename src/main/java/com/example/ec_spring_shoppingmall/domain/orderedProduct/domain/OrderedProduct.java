package com.example.ec_spring_shoppingmall.domain.orderedProduct.domain;

import com.example.ec_spring_shoppingmall.domain.model.BaseTimeEntity;
import com.example.ec_spring_shoppingmall.domain.order.domain.DeliveryOrder;
import com.example.ec_spring_shoppingmall.domain.orderedProduct.constant.OrderType;
import com.example.ec_spring_shoppingmall.domain.product.domain.Product;
import com.example.ec_spring_shoppingmall.domain.size.domain.Size;
import com.example.ec_spring_shoppingmall.domain.user.domain.User;
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
@Table(name = "ordered_product")
public class OrderedProduct extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderType orderType;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "size_id")
    private Size size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_order_id")
    private DeliveryOrder deliveryOrderId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

//    @OneToOne
//    @PrimaryKeyJoinColumn(name = "address_id")
//    private Address address;

    @Builder
    public OrderedProduct(OrderType orderType, Product product, Size size, User userId, Integer quantity) {
        this.orderType = orderType;
        this.product = product;
        this.size = size;
        this.userId = userId;
        this.quantity = quantity;
    }
}
