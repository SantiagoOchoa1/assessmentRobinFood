package com.RF.rest.mappers;

import com.RF.rest.dtos.EncuestaDto;
import com.RF.rest.dtos.OpcionDto;
import com.RF.rest.dtos.PreguntaDto;
import com.RF.rest.entities.Encuesta;
import com.RF.rest.entities.Opcion;
import com.RF.rest.entities.Pregunta;

import java.util.ArrayList;
import java.util.List;

public class EncuestaMapper {

    public EncuestaDto encuestaEntToDto(Encuesta encuesta) {

        List<OpcionDto> opcionDtos = new ArrayList<>();
        List<PreguntaDto> preguntaDtos = new ArrayList<>();

        for (Pregunta pregunta : encuesta.getPreguntas()) {
            for (Opcion opcion : pregunta.getOpciones()) {
                OpcionDto opcionDto = new OpcionDto(opcion.getId(), opcion.getDescripcion());
                opcionDtos.add(opcionDto);
            }
            PreguntaDto preguntaDto = new PreguntaDto(pregunta.getId(), pregunta.getDescripcion(), pregunta.getSeleccionMultiple(), null, opcionDtos);
            preguntaDtos.add(preguntaDto);

        }

        EncuestaDto encuestaDto = new EncuestaDto(encuesta.getId(), encuesta.getTitulo(), preguntaDtos);

        return encuestaDto;
    }
}
