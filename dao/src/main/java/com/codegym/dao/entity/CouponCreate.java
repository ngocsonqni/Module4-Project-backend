package com.codegym.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "coupon")
public class CouponCreate {
    @Id
    @Column(name = "coupon_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer couponId;

    @Column(name = "create_date")
    private Date createDate;


    @Column(name = "id_employee")
    private Integer employee;


    @Column(name = "id_user")
    private Integer user;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    public CouponCreate() {
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
