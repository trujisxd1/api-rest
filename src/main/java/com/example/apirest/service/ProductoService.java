package com.example.apirest.service;

import com.example.apirest.model.Producto;
import com.example.apirest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {


    @Autowired
    private ProductoRepository repository;


 public Producto saveProducto( Producto producto){

     return  this.repository.save(producto);

 }


public List<Producto> listar(){

     return  this.repository.getAllProductos();
}


public  Producto getProductoByid(int id){

     return this.repository.findByid(id);
}

public String deleyeproducto(int id){
    this.repository.delete(id);
     return  "producto eliminado " + id;

}

public  Producto updateProducto(Producto producto){

     return this.repository.update(producto);
    }


}
