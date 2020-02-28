package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table
public class TRoom {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private BigInteger capacity;
    @Column
    private BigInteger floor;
    @Column
    private BigInteger roomNumber;
}
