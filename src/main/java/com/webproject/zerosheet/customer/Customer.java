package com.webproject.zerosheet.customer;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// Clients
@Entity
@Table
public class Customer {
    @Id
    private String custID;
    private String custName;
    private String address;
    private String contactNo;

    public Customer() {
    }

    public Customer(String custID, String custName, String address, String contactNo) {
        this.custID = custID;
        this.custName = custName;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
}
