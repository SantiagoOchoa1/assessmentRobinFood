package com.RF.rest.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "descripcion_pregunta")
    private String descripcion;

    @Column(nullable = false)
    private boolean seleccionMultiple;

    @OneToMany(targetEntity = Respuesta.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "pregunta_fk",referencedColumnName = "id")
    private List<Respuesta> respuestas;

    @OneToMany(targetEntity = Opcion.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "pregOpcion_fk",referencedColumnName = "id")
    private List<Opcion> opciones;

    public boolean getSeleccionMultiple() {
        return seleccionMultiple;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSeleccionMultiple() {
        return seleccionMultiple;
    }

    public void setSeleccionMultiple(boolean seleccionMultiple) {
        this.seleccionMultiple = seleccionMultiple;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
