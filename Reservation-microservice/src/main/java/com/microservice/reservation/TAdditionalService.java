package com.microservice.reservation;

import com.microservice.reservation.validation.SQLInjectionSafe;
import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Table
@Entity
public class TAdditionalService {

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
