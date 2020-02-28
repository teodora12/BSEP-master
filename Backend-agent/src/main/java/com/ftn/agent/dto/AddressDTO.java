package com.ftn.agent.dto;

import com.ftn.agent.security.validation.SQLInjectionSafe;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressDTO {

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String country;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String city;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String street;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe String streetNumber;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe double longitude;

    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe double latitude;


    AddressDTO() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
