package com.webproject.zerosheet.transaction.purchase;

import com.webproject.zerosheet.vendor.Category;
import com.webproject.zerosheet.vendor.Vendor;


import javax.persistence.*;
import java.time.LocalDate;


@Entity (name = "Purchases")
@Table
public class Purchase {

    @Id
    @SequenceGenerator(
            name = "purchaseID",
            sequenceName = "purchaseID",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "purchaseID"
    )
    private long purchaseID;
    private LocalDate purchaseDate;
    private double amount;
    private int qty;
    private Category category;
    private String vendID;

    public Purchase() {
    }

    public Purchase(LocalDate purchaseDate, double amount, int qty, Category category, String vendID) {
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.qty = qty;
        this.category = category;
        this.vendID = vendID;
    }

    public Purchase(long purchaseID, LocalDate purchaseDate, double amount, int qty, Category category, String vendID) {
        this.purchaseID = purchaseID;
        this.purchaseDate = purchaseDate;
        this.amount = amount;
        this.qty = qty;
        this.category = category;
        this.vendID = vendID;
    }

    public long getPurchaseID() {
        return purchaseID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getAmount() {
        return amount;
    }

    public int getQty() {
        return qty;
    }

    public Category getCategory() {
        return category;
    }

    public String getVendID() {
        return vendID;
    }

    public void setPurchaseID(long purchaseID) {
        this.purchaseID = purchaseID;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setVendID(String vendID) {
        this.vendID = vendID;
    }
}
