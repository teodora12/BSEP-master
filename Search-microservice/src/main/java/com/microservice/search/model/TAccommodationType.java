package com.microservice.search.model;

import com.microservice.search.validation.SQLInjectionSafe;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class TAccommodationType {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @SafeHtml
    @NotBlank
    private @SQLInjectionSafe
    String name;
}
