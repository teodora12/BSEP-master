package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Address {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String streetNumber;

    @Column
    private double longitude;

    @Column
    private double latitude;
}
