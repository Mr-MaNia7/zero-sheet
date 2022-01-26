package com.webproject.zerosheet;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TransactionForm {
    private String transactionName;
    private String quantity;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dueBackDate;
}
