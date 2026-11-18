package com.puce.veterinaria.controller;

import com.puce.veterinaria.model.Mascota;
import com.puce.veterinaria.service.MascotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController {

    private MascotaService mascotaSerive;

    public MascotaController(MascotaService mascotaSerive) {

        this.mascotaSerive = mascotaSerive;
    }

    //LISTAR TODOS
    @GetMapping
    public List<Mascota> verTodos() {
        return mascotaSerive.traerTodos();
    }

    //TRAER UNA MASCOTA POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Mascota> traerUno(@PathVariable int id){
        return mascotaSerive.traerUno(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Mascota> guardar(@RequestBody Mascota mascota){
        Mascota nuevaMascota = mascotaSerive.guardar(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }
}
