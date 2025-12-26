package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.DetalleVentaDTO;
import com.ejercicio.PruebaTecSupermercado.dto.VentaDTO;
import com.ejercicio.PruebaTecSupermercado.mapper.Mapper;
import com.ejercicio.PruebaTecSupermercado.model.DetalleVenta;
import com.ejercicio.PruebaTecSupermercado.model.Producto;
import com.ejercicio.PruebaTecSupermercado.model.Sucursal;
import com.ejercicio.PruebaTecSupermercado.model.Venta;
import com.ejercicio.PruebaTecSupermercado.repository.ProductoRepository;
import com.ejercicio.PruebaTecSupermercado.repository.SucursalRepository;
import com.ejercicio.PruebaTecSupermercado.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private SucursalRepository sucursalRepo;

    @Override
    public List<VentaDTO> traerVentas() {

        List<Venta> ventas = ventaRepo.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();

        VentaDTO dto;

        for (Venta v : ventas){
            dto = Mapper.toDTO(v);
            ventasDto.add(dto);
        }

        return ventasDto;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDto) {

        //validaciones
        if (ventaDto == null) throw new RuntimeException("VentaDTO es nulL");
        if (ventaDto.getIdSucursal() == null) throw new RuntimeException("Debe indicar la sucursal");
        if (ventaDto.getDetalle() == null || ventaDto.getDetalle().isEmpty())
            throw new RuntimeException("Debe agregar al menos un producto");


        //Buscar la sucursal
        Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal())
                .orElse(null);
        if (suc == null) throw new RuntimeException("Sucursal no encontrada");

        //crear la venta
        Venta vent = new Venta();
        vent.setFecha(ventaDto.getFecha());
        vent.setEstado(ventaDto.getEstado());
        vent.setSucursal(suc);
        vent.setTotal(ventaDto.getTotal());

        // La lista de detalles
        // --> Acá estan los productos y cantidades

        List<DetalleVenta> detalles = new ArrayList<>();

        for (DetalleVentaDTO detDTO : ventaDto.getDetalle()) {
            //Buscar producto por id (tu detDTO usa id como id de producto)
            Producto p = productoRepo.findByNombre(detDTO.getNombreProd()).orElse(null);
            if (p == null) {
                throw new RuntimeException("Producto con id " + detDTO.getId() + " no encontrado");
            }

            //Crear el detalle
            DetalleVenta detalleVent = new DetalleVenta();
            detalleVent.setProducto(p);
            detalleVent.setPrecio(detDTO.getPrecio());
            detalleVent.setCantidadProducto(detDTO.getCantProd());
            detalleVent.setVenta(vent);

            detalles.add(detalleVent);

        }
        //Seteamos la lita de detalles a la venta
        vent.setDetalle(detalles);


        //Guardar la venta en la BD
        ventaRepo.save(vent);

        //Mapeo de salida
        VentaDTO ventaSalida = Mapper.toDTO(vent);

        return ventaSalida;

    }

    @Override
    public VentaDTO actualizarVenta(Long id, VentaDTO ventaDto) {
        //buscar si la venta existe
        Venta v = ventaRepo.findById(id).orElse(null);
        if (v == null) throw new RuntimeException("Venta no encontrada");

        if(ventaDto.getFecha() != null){
            v.setFecha(ventaDto.getFecha());
        }
        if(ventaDto.getEstado() != null){
            v.setEstado(ventaDto.getEstado());
        }

        if(ventaDto.getTotal() != null){
            v.setTotal(ventaDto.getTotal());
        }

        if(ventaDto.getIdSucursal() != null){
            Sucursal s = sucursalRepo.findById(ventaDto.getIdSucursal()).orElse(null);
            if (s == null) throw new RuntimeException("Sucursal no encontrada");
            v.setSucursal(s);
        }

        ventaRepo.save(v);

        VentaDTO ventaSalida = Mapper.toDTO(v);
        return ventaSalida;
    }

    @Override
    public void eliminarVenta(Long id) {

        Venta v = ventaRepo.findById(id).orElse(null);
        if (v == null) throw new RuntimeException("Venta no encontrada");
        ventaRepo.delete(v);

    }
}
