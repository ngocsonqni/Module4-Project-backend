package com.codegym.dao.DTO;

import java.util.Date;

public class CouponDTO {

    private String couponId;
    private Date createDate;
    private String employee;
    private String user;
    private String deleteFlag;

    private String productName;
    private String quantity;

    public CouponDTO(String couponId, Date createDate, String employee, String user, String deleteFlag, String productName, String quantity) {
        this.couponId = couponId;
        this.createDate = createDate;
        this.employee = employee;
        this.user = user;
        this.deleteFlag = deleteFlag;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
}
