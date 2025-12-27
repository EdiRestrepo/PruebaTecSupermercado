package com.ejercicio.PruebaTecSupermercado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Venta a la que pertenece el detalle. Muchas detalles pueden pertenecer a una venta
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "ventaId")
    private Venta venta;

    //Producto vendido. Muchas detalles pueden pertenecer a un producto
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "productoId")
    private Producto producto;

    private Integer cantidadProducto;

    private Double precio;
}
