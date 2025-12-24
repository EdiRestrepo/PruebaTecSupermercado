package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService {
    @Override
    public List<VentaDTO> traerVentas() {
        return List.of();
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDto) {
        return null;
    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDto) {
        return null;
    }

    @Override
    public void eliminarVenta(Long id) {

    }
}
