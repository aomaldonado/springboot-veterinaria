package com.puce.veterinaria.controller;

import com.puce.veterinaria.model.Duenio;
import com.puce.veterinaria.repository.DuenioRepository;
import com.puce.veterinaria.service.DuenioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DuenioController {

    private DuenioService duenioService;

    public DuenioController(DuenioRepository duenioRepository) {
        this.duenioService = duenioService;
    }

    //LISTAR TODOS
    @GetMapping
    public List<Duenio> verTodos() {
        return duenioService.traerTodos();
    }

    //TRAER UN DUENIO POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Duenio> traerUno(@PathVariable int id){
        return duenioService.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Duenio> guardar(@RequestBody Duenio mascota){
        Duenio nuevaMascota = duenioSerive.guardar(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }
}
