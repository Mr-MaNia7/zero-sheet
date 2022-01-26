package com.webproject.zerosheet;


import java.sql.Date;

import lombok.Data;

@Data
public class TransactionForm {
    private String transactionName;
    private String quantity;
    private Date dueBackDate;
}
