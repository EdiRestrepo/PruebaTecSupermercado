package com.ejercicio.PruebaTecSupermercado.service;

import com.ejercicio.PruebaTecSupermercado.dto.ProductoDTO;
import com.ejercicio.PruebaTecSupermercado.exception.NotFoundException;
import com.ejercicio.PruebaTecSupermercado.mapper.Mapper;
import com.ejercicio.PruebaTecSupermercado.model.Producto;
import com.ejercicio.PruebaTecSupermercado.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> traerProductos() {
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {

        var prod = Producto.builder()
                .nombre(productoDto.getNombre())
                .categoria(productoDto.getCategoria())
                .precio(productoDto.getPrecio())
                .cantidad(productoDto.getCantidad())
                .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto) {
        //Vamos a buscar si el producto existe

        Producto prod = repo.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encontró el producto"));

        prod.setNombre(productoDto.getNombre());
        prod.setCategoria(productoDto.getCategoria());
        prod.setCantidad(productoDto.getCantidad());
        prod.setPrecio(productoDto.getPrecio());

        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public void eliminarProducto(Long id) {

        if (!repo.existsById(id)){
            throw new NotFoundException("No se encontró el producto para eliminar");
        } else {
            repo.deleteById(id);
        }



    }
}
