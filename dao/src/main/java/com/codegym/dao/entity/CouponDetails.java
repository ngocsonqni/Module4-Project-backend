package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="coupon_detail")
public class CouponDetails {
    @Id
    @Column(name = "coupon_detail_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponDetailId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "coupon_id")
    private Integer couponId;

    public Integer getCouponDetailId() {
        return couponDetailId;
    }

    public void setCouponDetailId(Integer couponDetailsId) {
        this.couponDetailId = couponDetailsId;
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

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }
}
