package com.ftn.bsep.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table
@Entity
@Getter @Setter
public class Certificate implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @Column
    private String alias;

    @Column
    private Date issuingDate;

    @Column
    private Date expirationDate;

    @Column(length=1000)
    private String publicKey;

    @Column
    private String issuedTo;

    @Column
    private Long issuedById;

    @Column
    private String issuedBy;

    @Column
    private boolean isCA;

    @Column
    private State state;

    public Certificate(){}

    public Certificate(User user, String publicKey , Date issuingDate, Date expirationDate, Long issuedById, String issuedTo, String issuedBy, boolean isCA, String alias) {

        this.user = user;
        this.issuingDate = issuingDate;
        this.expirationDate = expirationDate;
        this.publicKey = publicKey;
        this.issuedById = issuedById;
        this.issuedTo = issuedTo;
        this.issuedBy = issuedBy;
        this.isCA = isCA;
        this.state = State.valid;
        this.alias = alias;
    }
}
