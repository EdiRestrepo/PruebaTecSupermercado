package com.ejercicio.PruebaTecSupermercado.repository;

import com.ejercicio.PruebaTecSupermercado.model.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository <Sucursal, Long> {
}
