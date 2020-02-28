package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
/**
 *  FALI cena(jer treba cenovnik da se ubaci da bih mogla da pokupim cenu za trazeni period)
 * */
@Data
@Entity
@Table
public class Accommodation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne
    private Address address;

    @OneToMany
    private List<TRoom> room;

    @Column
    private String description;

    @ManyToOne
    private TAccommodationType accommodationType;

    @ManyToOne
    private TAccommodationCategory accommodationCategory;

    @ManyToMany
    private List<TAdditionalServicesWithPrices> additionalServicesWithPrices;

    @OneToOne(cascade = CascadeType.ALL)
    private TCancellation cancellation;

    @Column
    private double rate;

    @ElementCollection
    @Column(name="picture")
    private List<String> picture;
// MSM DA NE TREBA OVDE
//    @OneToMany
//    private List<Comment> comments;

    @OneToOne
    private Pricelist pricelist;

    @Column
    private int numberOfPeopleCapacity;

}
