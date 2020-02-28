package com.ftn.bsep.model;

import com.ftn.bsep.model.modelGenerated.TAdditionalService;
import com.ftn.bsep.model.modelGenerated.TRoom;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "reservation")
@Table(name = "reservation")
@Data
public class ReservationForDatabase {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double price;

    @ManyToOne
    private User user;

    @Column
    private Date arrivalDate;

    @Column
    private Date departureDate;

    @Column
    private String status;


    @ManyToMany
    @JoinTable(name = "reservation_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TRoom> room;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TAdditionalService> paidAdditionalServices;

    @Column
    private Long numberOfDaysForCancellation;

    @Column
    private Long accommodationId;

    public ReservationForDatabase() {}

    public ReservationForDatabase(BigDecimal price, User user, Date arrivalDate, Date departureDate,
                                  List<TRoom> room, Long numberOfDaysForCancellation, List<TAdditionalService> paidAdditionalServices,
                                  Long accommodationId) {
        this.price = price.doubleValue();
        this.user = user;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
    //    this.status = status;
        this.room = room;
        this.numberOfDaysForCancellation = numberOfDaysForCancellation;
        this.paidAdditionalServices = paidAdditionalServices;
        this.accommodationId = accommodationId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TRoom> getRoom() {
        return room;
    }

    public void setRoom(List<TRoom> room) {
        this.room = room;
    }

    public List<TAdditionalService> getPaidAdditionalServices() {
        return paidAdditionalServices;
    }

    public void setPaidAdditionalServices(List<TAdditionalService> paidAdditionalServices) {
        this.paidAdditionalServices = paidAdditionalServices;
    }

    public Long getNumberOfDaysForCancellation() {
        return numberOfDaysForCancellation;
    }

    public void setNumberOfDaysForCancellation(Long numberOfDaysForCancellation) {
        this.numberOfDaysForCancellation = numberOfDaysForCancellation;
    }

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationForDatabase that = (ReservationForDatabase) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
