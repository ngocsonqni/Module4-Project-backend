package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_user")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "order_address")
    private String orderAddress;
    @Column(name = "total_money")
    private double totalMoney;
    @Column(name = "ordered_success")
    private LocalDateTime orderedSuccess;
    @Column(name = "received")
    private LocalDateTime received;
    @Column(name = "taking_orders")
    private LocalDateTime takingOrders;
    @Column(name ="hand_over_shipping")
    private LocalDateTime handOverShipping;
    @Column(name = "transporting")
    private LocalDateTime transporting;
    @Column(name = "successful_delivery")
    private LocalDateTime successfulDelivery;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "id.orderUser")
    @JsonManagedReference
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(int orderId, LocalDateTime orderDate, String orderStatus, String orderAddress, double totalMoney, LocalDateTime orderedSuccess, LocalDateTime received, LocalDateTime takingOrders, LocalDateTime handOverShipping, LocalDateTime transporting, LocalDateTime successfulDelivery, User user, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.totalMoney = totalMoney;
        this.orderedSuccess = orderedSuccess;
        this.received = received;
        this.takingOrders = takingOrders;
        this.handOverShipping = handOverShipping;
        this.transporting = transporting;
        this.successfulDelivery = successfulDelivery;
        this.user = user;
        this.orderDetailList = orderDetailList;
    }

    public LocalDateTime getOrderedSuccess() {
        return orderedSuccess;
    }

    public void setOrderedSuccess(LocalDateTime orderedSuccess) {
        this.orderedSuccess = orderedSuccess;
    }

    public LocalDateTime getReceived() {
        return received;
    }

    public void setReceived(LocalDateTime received) {
        this.received = received;
    }

    public LocalDateTime getTakingOrders() {
        return takingOrders;
    }

    public void setTakingOrders(LocalDateTime takingOrders) {
        this.takingOrders = takingOrders;
    }

    public LocalDateTime getHandOverShipping() {
        return handOverShipping;
    }

    public void setHandOverShipping(LocalDateTime handOverShipping) {
        this.handOverShipping = handOverShipping;
    }

    public LocalDateTime getTransporting() {
        return transporting;
    }

    public void setTransporting(LocalDateTime transporting) {
        this.transporting = transporting;
    }

    public LocalDateTime getSuccessfulDelivery() {
        return successfulDelivery;
    }

    public void setSuccessfulDelivery(LocalDateTime successfulDelivery) {
        this.successfulDelivery = successfulDelivery;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int order_id) {
        this.orderId = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime order_date) {
        this.orderDate = order_date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String order_status) {
        this.orderStatus = order_status;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String order_address) {
        this.orderAddress = order_address;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double total_money) {
        this.totalMoney = total_money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User id_user) {
        this.user = id_user;
    }
}
