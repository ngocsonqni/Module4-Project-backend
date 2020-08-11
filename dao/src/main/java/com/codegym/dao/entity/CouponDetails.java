package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="coupon_detail")
public class CouponDetails {
    @Id
    @Column(name = "coupon_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
