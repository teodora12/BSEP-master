package com.ftn.bsep.dto.accommodation;

import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdditionalWithPricesDTO {

    private Long id;

    @NotNull
    private double price;

//    @NotNull
//    private boolean included;



    public AdditionalWithPricesDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
