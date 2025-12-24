package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.SucursalDTO;
import com.ejercicio.PruebaTecSupermercado.model.Sucursal;

import java.util.List;

public interface ISurcursalService {

    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto);
    void eliminarSucursal(Long id);
}
