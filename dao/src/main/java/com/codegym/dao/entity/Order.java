package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @ManyToOne
    @JoinColumn(name = "type_of_shipping")
    private TypeOfShipping typeOfShipping;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "delivery_phone_number")
    private String deliveryPhoneNumber;
    @Column(name = "expected_delivery_date")
    private LocalDateTime expectedDeliveryDate;
    @Column(name = "type_of_payment")
    private String typeOfPayment;
    @Column(name = "ordered_success")
    private LocalDateTime orderedSuccess;
    @Column(name = "received")
    private LocalDateTime received;
    @Column(name = "taking_orders")
    private LocalDateTime takingOrders;
    @Column(name = "hand_over_shipping")
    private LocalDateTime handOverShipping;
    @Column(name = "transporting")
    private LocalDateTime transporting;
    @Column(name = "successful_delivery")
    private LocalDateTime successfulDelivery;
    @ManyToOne
    @JoinColumn(name = "id_user")
//    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //    @JsonBackReference(value = "user")
    private User user;
    @OneToMany(mappedBy = "id.orderUser")
//    @JsonManagedReference(value="orderDetailList")
    private List<OrderDetail> orderDetailList;

    public Order() {
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

    public TypeOfShipping getTypeOfShipping() {
        return typeOfShipping;
    }

    public void setTypeOfShipping(TypeOfShipping typeOfShipping) {
        this.typeOfShipping = typeOfShipping;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getDeliveryPhoneNumber() {
        return deliveryPhoneNumber;
    }

    public void setDeliveryPhoneNumber(String deliveryPhoneNumber) {
        this.deliveryPhoneNumber = deliveryPhoneNumber;
    }

    public LocalDateTime getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(LocalDateTime expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(String typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }
}
