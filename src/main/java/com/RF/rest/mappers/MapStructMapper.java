package com.RF.rest.mappers;

import com.RF.rest.dtos.EncuestaDto;
import com.RF.rest.dtos.PreguntaDto;
import com.RF.rest.entities.Encuesta;
import com.RF.rest.entities.Pregunta;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MapStructMapper {

    public EncuestaDto encuestaToEncuestaDto(Encuesta encuestaEntity);

    public Encuesta encuestaDtoToEncuestaEntity(EncuestaDto encuestaDto);

    @Mapping(target = "respuestas",ignore = true)
    public PreguntaDto preguntaToPreguntaDto(Pregunta pregunta);
}
