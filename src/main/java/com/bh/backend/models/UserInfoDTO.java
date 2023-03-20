package com.bh.backend.models;

public class UserInfoDTO {
    private Integer customerID;
    private Double initialCredit;

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(Double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
