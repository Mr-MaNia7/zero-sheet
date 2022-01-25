package com.webproject.zerosheet.inventory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Products")
@Table
public class Product {

    @Id
    private String productID;
    private String productName;
    private State state;
    private int qty;
    private double price;
}
