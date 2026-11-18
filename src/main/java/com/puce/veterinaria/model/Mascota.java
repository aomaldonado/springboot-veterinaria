package com.puce.veterinaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Mascota {
    @Id
    private int id;
    private String nombre;
    private String especie;
    private int edad;
    private String duenio;
}
