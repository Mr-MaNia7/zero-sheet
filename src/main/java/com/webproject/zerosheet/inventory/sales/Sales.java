package com.webproject.zerosheet.inventory.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity (name = "sales")
public class Sales {

    @Id
    @SequenceGenerator(
            name = "salesID",
            sequenceName = "salesID",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "salesID"
    )
    private long salesID;
    private LocalDate salesDate;
    private String custID;
    private double amount;
    private double tax;
    private int qty;

    public Sales() {
    }

    public Sales(LocalDate date, String custID, double amount, double tax, int qty) {
        this.salesDate = date;
        this.custID = custID;
        this.amount = amount;
        this.tax = tax;
        this.qty = qty;
    }

    public Sales(long salesID, LocalDate date, String custID, double amount, double tax, int qty) {
        this.salesID = salesID;
        this.salesDate = date;
        this.custID = custID;
        this.amount = amount;
        this.tax = tax;
        this.qty = qty;
    }

    public long getSalesID() {
        return salesID;
    }

    public void setSalesID(long salesID) {
        this.salesID = salesID;
    }

    public LocalDate getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

