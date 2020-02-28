package com.microservice.reservation;


import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table
@Entity
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @Column
    private boolean enabled;

}