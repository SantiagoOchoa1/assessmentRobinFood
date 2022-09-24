package com.RF.rest.controller;

import com.RF.rest.dtos.EncuestaDto;
import com.RF.rest.services.EncuestaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EncuentaController {

    private EncuestaService encuestaService;

    public EncuentaController(EncuestaService encuestaService) {
        this.encuestaService = encuestaService;
    }

    @GetMapping("encuesta/{id}")
    public ResponseEntity<?> listEncuesta(@PathVariable(value = "id") Long id) {

        return new ResponseEntity<>(encuestaService.listarEncuesta(id), HttpStatus.OK);
    }

    @PostMapping("/agregarEncuesta")
    public ResponseEntity<?> crearEncuesta(@RequestBody EncuestaDto encuestaDto) {
        return new ResponseEntity<>(encuestaService.crearEncuesta(encuestaDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/guardarInfo/{id}")
    public ResponseEntity<?> guardarInfoEncuesta(@PathVariable(name = "id") Long id, @RequestBody EncuestaDto encuestaDto) {
        return new ResponseEntity<>(encuestaService.guardarEncuesta(id,encuestaDto), HttpStatus.OK);
    }
}
