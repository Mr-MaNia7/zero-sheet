package com.webproject.zerosheet.inventory;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "product")
public class Products {

    @Id
    @SequenceGenerator(
            name = "productSeq",
            sequenceName = "productSeq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "productSeq"
    )
    private Long prodID;

    private String prodName;
    private String prodType;
    private double unitPrice;

    private State state;

    public enum State {
        AVAILABLE,
        LOAN,
        MAINTENANCE,
        UNAVAILABLE
    }
}
