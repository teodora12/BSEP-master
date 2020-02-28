package com.ftn.bsep.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Table
@Entity
@Getter @Setter
public class Keystore implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String  password;

    public Keystore() {
    }

    public Keystore(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
