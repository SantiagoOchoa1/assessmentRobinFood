package com.RF.rest.services;

import com.RF.rest.dtos.EncuestaDto;
import com.RF.rest.dtos.OpcionDto;
import com.RF.rest.dtos.PreguntaDto;
import com.RF.rest.entities.Encuesta;
import com.RF.rest.entities.Opcion;
import com.RF.rest.repositories.EncuestasRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class EncuestaServiceTest {

    @Mock
    private EncuestasRepository encuestasRepository;
    private EncuestaService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EncuestaService(encuestasRepository, new ModelMapper());
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void listarEncuestaDadoUnId() {
        //given
        Long idEncuesta = Long.valueOf(1);
        //given
        OpcionDto opcionDto = new OpcionDto(Long.valueOf(1), "A");
        OpcionDto opcionDto2 = new OpcionDto(Long.valueOf(1), "B");
        PreguntaDto preguntaDto = new PreguntaDto(Long.valueOf(1), "cual prefieres", true,null, List.of(opcionDto, opcionDto2));
        EncuestaDto encuestaDto = new EncuestaDto(Long.valueOf(2), "encuesta1", List.of(preguntaDto));

        //when
        given(encuestasRepository.findById(idEncuesta)).willReturn(Optional.of(new Encuesta()));
        underTest.listarEncuesta(idEncuesta);

        verify(encuestasRepository).findById(idEncuesta);
    }

    @Test
    void crearEncuesta() {
        //given
        OpcionDto opcionDto = new OpcionDto(Long.valueOf(1), "A");
        OpcionDto opcionDto2 = new OpcionDto(Long.valueOf(1), "B");
        PreguntaDto preguntaDto = new PreguntaDto(Long.valueOf(1), "cual prefieres", true,null, List.of(opcionDto, opcionDto2));
        EncuestaDto encuestaDto = new EncuestaDto(Long.valueOf(2), "encuesta1", List.of(preguntaDto));

        //when
        underTest.crearEncuesta(encuestaDto);

        //then
        verify(encuestasRepository).save(any());
    }
}