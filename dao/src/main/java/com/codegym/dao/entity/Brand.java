package com.codegym.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "brand")
public class Brand {
//    private final String WEBSITE_REGEXP = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+(\\.[a-z]{2,}){1,3}(#?\\/?[a-zA-Z0-9#]+)*\\/?(\\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int id;
    @Column(name = "brand_logo")
    private String brandLogo;
    @Column(name = "brand_name")
    @NotBlank (message = "Tên thương hiệu không được để trống")
    @Size(max = 50, message = "Tên thương hiệu không quá 50 ký tự")
    @Pattern(regexp = "^((?!\\s{2,})[a-zA-Z0-9\\_\\-\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ" +
            "ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế])*$",
    message = "Tên thương hiệu sai định dạng")
    private String brandName;
    @Column(name = "brand_address")
    @NotBlank (message = "Trụ sở thương hiệu không được để trống")
    @Size(max = 100, message = "Địa chỉ thương hiệu không quá 100 ký tự")
    @Pattern(regexp = "^((?!\\s{2,})[a-zA-Z0-9\\_\\-\\sÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂ" +
            "ưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹế])*$",
            message = "Địa chỉ thương hiệu sai định dạng")
    private String brandAddress;
    @Column(name = "brand_website")
    @NotBlank (message = "Website thương hiệu không được để trống")
    @Size(max = 50, message = "Website không quá 50 ký tự")
    @Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+(\\.[a-z]{2,}){1,3}(#?\\/?[a-zA-Z0-9#]+)*\\/?(\\?[a-zA-Z0-9-_]+=[a-zA-Z0-9-%]+&?)?$",
            message = "Website sai định dạng")
    private String brandWebsite;
    @Column(name = "delete_flag")
    private boolean deleteFlag;
    public Brand() {
    }

    public Brand(String brandLogo, String brandName, String brandAddress, String brandWebsite) {
        this.brandLogo = brandLogo;
        this.brandName = brandName;
        this.brandAddress = brandAddress;
        this.brandWebsite = brandWebsite;
        this.deleteFlag = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandAddress() {
        return brandAddress;
    }

    public void setBrandAddress(String brandAddress) {
        this.brandAddress = brandAddress;
    }

    public String getBrandWebsite() {
        return brandWebsite;
    }

    public void setBrandWebsite(String brandWebsite) {
        this.brandWebsite = brandWebsite;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}