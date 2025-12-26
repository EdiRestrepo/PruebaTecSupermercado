package com.ejercicio.PruebaTecSupermercado.repository;

import com.ejercicio.PruebaTecSupermercado.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {

    //Buscar producto por nombre
    Optional<Producto> findByNombre(String nombre);
}
