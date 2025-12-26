package com.ejercicio.PruebaTecSupermercado.controller;


import com.ejercicio.PruebaTecSupermercado.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;
}
