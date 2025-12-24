package com.ejercicio.PruebaTecSupermercado.repository;

import com.ejercicio.PruebaTecSupermercado.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository <Venta, Long> {
}
