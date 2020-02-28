package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class TAdditionalServicesWithPrices {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private TAdditionalService additionalServices;
    @Column
    private double price;

}
