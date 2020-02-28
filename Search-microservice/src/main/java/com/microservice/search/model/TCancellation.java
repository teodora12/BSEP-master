package com.microservice.search.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class TCancellation {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean isEnabled;
    @Column
    private int days;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
