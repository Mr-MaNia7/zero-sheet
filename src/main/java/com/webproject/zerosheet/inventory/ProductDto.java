package com.webproject.zerosheet.inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private String prodName;
    private String prodType;
    private double unitPrice;
    private Products.State state;

}
