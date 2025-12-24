package com.ejercicio.PruebaTecSupermercado.repository;

import com.ejercicio.PruebaTecSupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
}
