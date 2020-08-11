package com.codegym.dao.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;
    @Column(name = "user_name")
//    @NotBlank(message = "Tên khách hàng không được để trống!")
    @Pattern(regexp = "[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế][a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế ]*",
                        message = "Tên khách khàng không được chứa kí tự đặc biệt!")
    private String userName;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "address")
//    @NotBlank(message = "Địa chỉ không được để trống!")
    private String address;
    @Column(name = "email")
//    @NotBlank(message = " Email không được để trống!")
//    @Pattern(regexp = "[A-Za-z0-9]+(\\.?[A-Za-z0-9])*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)",message = "Số điện thoại không đúng định dạng (090xxxxxxx or 091xxxxxxx or (84)+90xxxxxxx or (84)+91xxxxxxx, x là số")
    private String email;
    @Column(name = "phone")
//    @NotBlank(message = " Số điện thoại không được để trống!")
//    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[0-9]{7}",message = "Email không đúng định dạng (ví dụ: son.94@gmail.com)")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

//    public Set<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(Set<Order> orderList) {
//        this.orderList = orderList;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
