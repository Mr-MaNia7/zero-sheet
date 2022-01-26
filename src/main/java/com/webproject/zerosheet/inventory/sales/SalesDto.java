package com.webproject.zerosheet.inventory.sales;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {

    @NotNull
    @NotBlank
    private LocalDate salesDate;

    @NotNull
    @NotBlank
    private String custID;

    @NotNull
    @NotBlank
    private double amount;

    @NotNull
    @NotBlank
    private double tax;

    @NotNull
    @NotBlank
    private int qty;
}
