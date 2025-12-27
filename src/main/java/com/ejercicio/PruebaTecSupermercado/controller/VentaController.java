package com.ejercicio.PruebaTecSupermercado.controller;

import com.ejercicio.PruebaTecSupermercado.dto.VentaDTO;
import com.ejercicio.PruebaTecSupermercado.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private IVentaService ventaService;

    @GetMapping
    public ResponseEntity<List<VentaDTO>> traerVentas() {
        List<VentaDTO> ventas = ventaService.traerVentas();
        return ResponseEntity.ok(ventas);
    }

    /**
     * Crea una venta usando directamente VentaDTO en la request (opción simple, sin request separado).
     * Se espera que el DTO traiga la información.
     */

    @PostMapping
    public ResponseEntity<VentaDTO> crearVenta(@RequestBody VentaDTO dto) {
        VentaDTO creado = ventaService.crearVenta(dto);
        return ResponseEntity.created(URI.create("/api/ventas/" + creado.getId())).body(creado);
    }

    @PutMapping("/{id}")
    public VentaDTO actualizarVenta(@PathVariable Long id, @RequestBody VentaDTO dto) {
      // Actualiza fecha, estado, idSucursal, total y detalles de la venta
        return ventaService.actualizarVenta(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVenta(@PathVariable Long id) {
        ventaService.eliminarVenta(id);
        return ResponseEntity.noContent().build();
    }



}
