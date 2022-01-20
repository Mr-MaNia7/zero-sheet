package com.webproject.zerosheet.transaction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transactionID",
            sequenceName = "transactionID",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transactionID"
    )
    private long transID;
    private LocalDate date;
    private String bankAcc;
    private double amount;
}
