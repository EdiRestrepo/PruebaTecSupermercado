package com.ejercicio.PruebaTecSupermercado.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Venta a la que pertenece el detalle. Muchas detalles pueden pertenecer a una venta
    @ManyToOne
    private Venta venta;

    //Producto vendido. Muchas detalles pueden pertenecer a un producto
    @ManyToOne
    private Producto producto;

    private Integer cantidadProducto;

    private Double precio;
}
