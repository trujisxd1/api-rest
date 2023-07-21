package com.example.apirest.controller;


import com.example.apirest.model.Producto;
import com.example.apirest.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService service;


    @GetMapping("/listar")
    public List<Producto> listar(){

        return service.listar();
    }


    @PostMapping
    public  Producto agregarProducto(@RequestBody Producto producto){

        return  service.saveProducto(producto);
    }



    @GetMapping("buscar/{id}")
    public  Producto buscarProducto(@PathVariable int id){


        return  service.getProductoByid(id);
    }


    @PutMapping("")
    public  Producto actualizar(@RequestBody Producto producto){

        return  service.updateProducto(producto);
    }


    @DeleteMapping("eliminar/{id}")
    public  String eliminarProducto(@PathVariable int id){


        return service.deleyeproducto(id);
    }
}
