package com.microservice.reservation;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
@Table
@Entity
public class Reservation {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private BigDecimal price;
    @Column
    private Date arrivalDate;
    @Column
    private Date departureDate;
    @ManyToMany
    @JoinTable(name = "reservation_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<TRoom> room;
    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "reservation_paid_additional_services",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "paid_additional_services_id"))
    private List<TAdditionalService> paidAdditionalServices;

    @Column
    private Long numberOfDaysForCancellation;

    @Column
    private Long accommodationId;

    @Column
    private String status;
}
