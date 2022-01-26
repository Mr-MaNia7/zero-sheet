package com.webproject.zerosheet.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSeq"
    )
    @SequenceGenerator(
            name = "productSeq",
            sequenceName = "productSeq",
            allocationSize = 1
    )
    private Long id;
    // @NotBlank(message = "Item name is required")
    private String name;
    private String unit;
    private double expectedArea;
    private double unitPrice;
    private int totalQuantity;
    private int loanquant;
    private int maintenancequant;
}
