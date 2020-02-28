package com.microservice.reservation;

import lombok.Data;

import javax.persistence.*;


@Table
@Entity
@Data
public class TCancellation {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean isEnabled;
    @Column
    private int days;

}
