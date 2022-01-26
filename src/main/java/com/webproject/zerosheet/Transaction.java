package com.webproject.zerosheet;

//import org.springframework.data.annotation.Id;


import lombok.Data;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private String transactionName;

    private String quantity;

    private Date dueBackDate;

}
