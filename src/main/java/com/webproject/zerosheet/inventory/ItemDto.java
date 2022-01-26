package com.webproject.zerosheet.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private String name;
    private String unit;
    private double expectedArea;
    private double unitPrice;
    private int totalQuantity;
    private int loanquant;
    private int maintenancequant;

}
