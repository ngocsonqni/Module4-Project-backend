package com.codegym.dao.DTO;

public class AccountDTOEmployee {
    private String accountName;
    private String oldPassword;
    private String accountPassword;

    public AccountDTOEmployee(String accountName, String oldPassword, String accountPassword) {
        this.accountName = accountName;
        this.oldPassword = oldPassword;
        this.accountPassword = accountPassword;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
}
