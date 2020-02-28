package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
public class Item {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Date startDatePeriod;
    @Column
    private Date endDatePeriod;
    @Column
    private double price;
    @Column
    private int capacity;
}
