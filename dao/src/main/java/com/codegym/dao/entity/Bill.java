//package com.codegym.dao.entity;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "bill")
//public class Bill {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    @Column(name = "id_bill")
//    private Integer id;
//
//    @Column(name = "bill_name")
//    private String billName;
//
//    @Column(name = "create_date")
//    private Date createDate;
//
//    @Column(name = "bill_status")
//    private String billStatus;
//
//    @Column(name = "processing_status")
//    private String processingStatus;
//
//    @Column(name = "shipping_status")
//    private String shippingStatus;
//
//    @Column(name = "payment_status")
//    private String paymentStatus;
//
//    @ManyToOne
//    @JoinColumn(name = "id_type_bill")
//    private TypeBill idTypeBill;
//
//    @ManyToOne
//    @JoinColumn(name = "id_storage_location")
//    private StorageLocation idStorageLocation;
//
//    @ManyToOne
//    @JoinColumn(name = "id_ware_house")
//    private WareHouse idWareHouse;
//
//    @ManyToOne
//    @JoinColumn(name = "id_transportation")
//    private Transportation idTransportation;
//
//    @ManyToOne
//    @JoinColumn(name = "id_pay")
//    private Pay idPay;
//
//    @ManyToOne
//    @JoinColumn(name = "id_distributor")
//    private Distributor idDistributor;
//
//    @ManyToOne
//    @JoinColumn(name = "id_employee")
//    private Employee idEmployee;
//
//    @Column(name = "delete_flag")
//    private Boolean deletaFlag;
//
//    public Boolean getDeletaFlag() {
//        return deletaFlag;
//    }
//
//    public void setDeletaFlag(Boolean deletaFlag) {
//        this.deletaFlag = deletaFlag;
//    }
//}
