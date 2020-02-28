package com.ftn.bsep.dto.accommodation;

import com.ftn.bsep.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ItemDTO {

    private Date startDatePeriod;


    private Date endDatePeriod;

    @NotNull
    private  Integer capacity;

    @NotNull
    private double price;

    public ItemDTO() {}

    public Date getStartPeriodDate() {
        return startDatePeriod;
    }

    public void setStartPeriodDate(Date startDatePeriod) {
        this.startDatePeriod = startDatePeriod;
    }

    public Date getEndPeriodDate() {
        return endDatePeriod;
    }

    public void setEndPeriodDate(Date endDatePeriod) {
        this.endDatePeriod = endDatePeriod;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
