package com.webproject.zerosheet.vendor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
// Purchase providers
public class Vendor {
    @Id
    private String vendID;
    private String vendName;
    private String bankAcc;
    private category category;
    private String address;

    // Type of purchase from vendors
    private enum category{
        Communication,
        Maintenance,
        RawMaterials,
        Housing
    }

    public Vendor() {
    }

    public Vendor(String vendName, String bankAcc, Vendor.category category, String address) {
        this.vendName = vendName;
        this.bankAcc = bankAcc;
        this.category = category;
        this.address = address;
    }

    public Vendor(String vendID, String vendName, String bankAcc, Vendor.category category, String address) {
        this.vendID = vendID;
        this.vendName = vendName;
        this.bankAcc = bankAcc;
        this.category = category;
        this.address = address;
    }

    public String getVendID() {
        return vendID;
    }

    public void setVendID(String vendID) {
        this.vendID = vendID;
    }

    public String getVendName() {
        return vendName;
    }

    public void setVendName(String vendName) {
        this.vendName = vendName;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }

    public Vendor.category getCategory() {
        return category;
    }

    public void setCategory(Vendor.category category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
