package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    int accountId;

    @Column(name = "account_name")
    String accountName;
    @Column(name = "account_password")
    String accountPassword;
    @Column(name = "delete_flag")
    boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    @OneToMany(mappedBy = "account")
    @JsonManagedReference
    public List<Employee> employees;

    public Account() {
    }

    public Account(String accountName, String accountPassword, boolean deleteFlag) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.deleteFlag = deleteFlag;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}