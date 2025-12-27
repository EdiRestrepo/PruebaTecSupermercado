package com.ejercicio.PruebaTecSupermercado.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VentaDTO {
    //datos de la venta
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private String estado;

    //datos de la sucursal
    private Long idSucursal;

    //lista de detalles
    private List<DetalleVentaDTO> detalle;

    //total de la venta
    private Double total;
}
