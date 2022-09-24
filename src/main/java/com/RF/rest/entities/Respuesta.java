package com.RF.rest.entities;

import javax.persistence.*;

@Entity
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "rta")
    private String rta;

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
