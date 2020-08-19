package com.codegym.dao.DTO;

import com.codegym.dao.entity.CouponDetails;

import java.util.ArrayList;
import java.util.Date;

public class CouponDTO {

    private Integer couponId;
    private Date createDate;
    private Integer employeeId;
    private Integer userId;
    private Boolean deleteFlag;

    private ArrayList<CouponDetails> couponDetails;

    public CouponDTO(Integer couponId, Date createDate, Integer employeeId, Integer userId, Boolean deleteFlag, ArrayList<CouponDetails> couponDetails) {
        this.couponId = couponId;
        this.createDate = createDate;
        this.employeeId = employeeId;
        this.userId = userId;
        this.deleteFlag = deleteFlag;
        this.couponDetails = couponDetails;
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public ArrayList<CouponDetails> getCouponDetails() {
        return couponDetails;
    }

    public void setCouponDetails(ArrayList<CouponDetails> couponDetails) {
        this.couponDetails = couponDetails;
    }
}
