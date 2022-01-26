package com.webproject.zerosheet;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private String id;
    // @NotBlank(message = "Item name is required")
    private String name;
    private String unit;
    private double expectedArea;
    private double unitPrice;
    private int totalQuantity;
    private int loanquant;
    private int maintenancequant;
}
