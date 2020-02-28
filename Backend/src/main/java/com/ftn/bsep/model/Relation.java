package com.ftn.bsep.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter @Setter @NoArgsConstructor
public class Relation {


    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long firstUserId;

    @Column
    private Long secondUserId;

}
