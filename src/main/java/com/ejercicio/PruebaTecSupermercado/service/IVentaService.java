package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.VentaDTO;

import java.util.List;

public interface IVentaService {

    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(VentaDTO ventaDto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaDto);
    void eliminarVenta(Long id);
}
