package com.RF.rest.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PreguntaDto implements Serializable {
    private final Long id;
    private final String descripcion;
    private final boolean seleccionMultiple;
    private final List<RespuestaDto> respuestas;
    private final List<OpcionDto> opciones;

    public PreguntaDto(Long id, String descripcion, boolean seleccionMultiple, List<RespuestaDto> respuestas, List<OpcionDto> opciones) {
        this.id = id;
        this.descripcion = descripcion;
        this.seleccionMultiple = seleccionMultiple;
        this.respuestas = respuestas;
        this.opciones = opciones;
    }

    public Long getId() {
        return id;
    }

    public boolean getSeleccionMultiple() {
        return seleccionMultiple;
    }

    public List<RespuestaDto> getRespuestas() {
        return respuestas;
    }

    public List<OpcionDto> getOpciones() {
        return opciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaDto entity = (PreguntaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.seleccionMultiple, entity.seleccionMultiple) &&
                Objects.equals(this.respuestas, entity.respuestas) &&
                Objects.equals(this.opciones, entity.opciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seleccionMultiple, respuestas, opciones);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "seleccionMultiple = " + seleccionMultiple + ", " +
                "respuestas = " + respuestas + ", " +
                "opciones = " + opciones + ")";
    }
}
