package com.example.apirest.repository;


import com.example.apirest.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepository {

    private List<Producto> productos  = new ArrayList<>();


    public  List<Producto> getAllProductos(){

        return productos;

    }


    public  Producto findByid(int id){

         for(int i = 0; i<productos.size(); i++){

            if (productos.get(i).getId()==id){
                return productos.get(i);
            }
        }
        return null;
    }


    public List<Producto> search (String nombre){

        return productos.stream().filter(x ->  x.getNombre().startsWith(nombre) ).collect(Collectors.toList());

    }

    public Producto save(Producto p){

        Producto producto = new Producto();
        producto.setId(p.getId());
        producto.setNombre(p.getNombre());
        producto.setCantidad(p.getCantidad());
        producto.setPrecio(p.getPrecio());

        productos.add(producto);

        return producto;
    }


    public  String delete(Integer id){

        productos.removeIf(x -> x.getId()==id);

        return null;
    }

    public  Producto update(Producto producto){

        int idX=0;
        int id=0;


        for (int i =0; i<productos.size(); i++){

            if (productos.get(i).getId()==(producto.getId())){

                id= producto.getId();
                idX=i;
                break;
            }
        }

        Producto producto1 =new Producto();
        producto1.setId(producto.getId());
        producto1.setNombre(producto.getNombre());
        producto1.setCantidad(producto.getCantidad());
        producto1.setPrecio(producto.getPrecio());

        productos.set(idX,producto);
        return producto;

    }
}
