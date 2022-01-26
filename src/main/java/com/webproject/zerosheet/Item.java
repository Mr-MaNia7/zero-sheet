package com.webproject.zerosheet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Id;

//import javax.validation.constraints.NotBlank;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "items")
@Entity
public class Item {
    @Id
    private String id;
    //@NotBlank(message = "Item name is required")
    private String name;
    private String unit;
    private double expectedArea;
    private double unitPrice;
    private int totalQuantity;
    private int loanquant;
    private int maintenancequant;
}
