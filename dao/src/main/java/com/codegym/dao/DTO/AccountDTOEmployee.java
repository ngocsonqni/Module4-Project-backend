package com.codegym.dao.DTO;

public class AccountDTOEmployee {
    private String accountName;
    private String oldPassword;
    private String accountPassword;
    private String otp;

    public AccountDTOEmployee(String accountName, String oldPassword, String accountPassword, String otp) {
        this.accountName = accountName;
        this.oldPassword = oldPassword;
        this.accountPassword = accountPassword;
        this.otp = otp;
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
