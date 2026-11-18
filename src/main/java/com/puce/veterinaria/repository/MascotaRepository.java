package com.puce.veterinaria.repository;

import com.puce.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
