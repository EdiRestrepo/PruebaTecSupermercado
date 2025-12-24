package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.SucursalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService implements ISurcursalService {
    @Override
    public List<SucursalDTO> traerSucursales() {
        return List.of();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDto) {
        return null;
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto) {
        return null;
    }

    @Override
    public void eliminarSucursal(Long id) {

    }
}
