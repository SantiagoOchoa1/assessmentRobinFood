package com.RF.rest.dtos;

import java.io.Serializable;
import java.util.Objects;

public class OpcionDto implements Serializable {
    private final Long id;
    private final String descripcion;

    public OpcionDto(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpcionDto entity = (OpcionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.descripcion, entity.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "descripcion = " + descripcion + ")";
    }
}
