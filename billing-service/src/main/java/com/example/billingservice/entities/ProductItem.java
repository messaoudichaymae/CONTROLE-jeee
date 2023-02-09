package com.example.billingservice.entities;

import com.example.billingservice.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double quantity;
    private double price;
    private long productID;
    @ManyToOne
    private Bill bill;
    @Transient @JsonIgnore
    private Product product;
    @Transient
    private String productName;

    public double getAmount(){
        return price*quantity;
    }

}
