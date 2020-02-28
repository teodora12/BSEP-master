package com.microservice.reservation;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Accommodation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<TRoom> room;

    @OneToOne(cascade = {CascadeType.ALL})
    private Pricelist pricelist;

    @OneToOne
    private TCancellation cancellation;
}
