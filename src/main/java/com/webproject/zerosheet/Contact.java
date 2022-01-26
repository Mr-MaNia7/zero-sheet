package com.webproject.zerosheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private String cfname;
}
