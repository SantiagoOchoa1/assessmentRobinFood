package com.RF.rest.services;

import com.RF.rest.dtos.EncuestaDto;
import com.RF.rest.entities.Encuesta;
import com.RF.rest.entities.Pregunta;
import com.RF.rest.mappers.EncuestaMapper;
import com.RF.rest.mappers.MapStructMapper;
import com.RF.rest.repositories.EncuestasRepository;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EncuestaService {

    private EncuestasRepository encuestasRepository;
    private ModelMapper modelMapper;

    private MapStructMapper mapper;

    public EncuestaService(EncuestasRepository encuestasRepository, ModelMapper modelMapper) {
        this.encuestasRepository = encuestasRepository;
        this.modelMapper = modelMapper;
        this.mapper = Mappers.getMapper(MapStructMapper.class);
    }

    public EncuestaDto listarEncuesta(Long id) {
        Optional<Encuesta> encuesta = encuestasRepository.findById(id);
        return mapper.encuestaToEncuestaDto(encuesta.get());
    }

    public Encuesta crearEncuesta(EncuestaDto encuestaDto) {
        //Encuesta encuesta = modelMapper.map(encuestaDto, Encuesta.class);
        Encuesta encuesta = mapper.encuestaDtoToEncuestaEntity(encuestaDto);
        return encuestasRepository.save(encuesta);
    }

    public EncuestaDto guardarEncuesta(Long id, EncuestaDto encuestaDto) {
        Encuesta encuestaToAdd = mapper.encuestaDtoToEncuestaEntity(encuestaDto);

        Optional<Encuesta> encuesta = encuestasRepository.findById(id);

        encuesta.ifPresent(encuesta1 -> encuesta1.getPreguntas().forEach(pregunta -> {
            Long idPregunta = pregunta.getId();
            Optional<Pregunta> any = encuestaToAdd.getPreguntas().stream().filter(preguntaToMap -> preguntaToMap.getId() == idPregunta).findAny();
            pregunta.getRespuestas().addAll(any.get().getRespuestas());
        }));

        return mapper.encuestaToEncuestaDto(encuestasRepository.save(encuesta.get()));
    }
}
