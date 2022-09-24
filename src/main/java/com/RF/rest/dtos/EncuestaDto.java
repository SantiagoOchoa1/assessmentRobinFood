package com.RF.rest.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class EncuestaDto implements Serializable {
    private final Long id;
    private final String titulo;
    private final List<PreguntaDto> preguntas;

    public EncuestaDto(Long id, String titulo, List<PreguntaDto> preguntas) {
        this.id = id;
        this.titulo = titulo;
        this.preguntas = preguntas;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<PreguntaDto> getPreguntas() {
        return preguntas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncuestaDto entity = (EncuestaDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.titulo, entity.titulo) &&
                Objects.equals(this.preguntas, entity.preguntas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, preguntas);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "titulo = " + titulo + ", " +
                "preguntas = " + preguntas + ")";
    }
}
