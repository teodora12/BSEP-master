package com.ftn.bsep.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
@Getter @Setter @NoArgsConstructor
public class CertificateStatus implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long certificateId;

    @Column
    private State state;

}
