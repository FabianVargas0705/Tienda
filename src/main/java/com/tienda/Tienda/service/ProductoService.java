/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.Tienda.service;

import com.tienda.Tienda.domain.Producto;
import java.util.List;

/**
 *
 * @author Fabian Vargas
 */
public interface ProductoService {
    
    public List<Producto> getProductos(boolean activos);
    
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Producto producto);
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
        //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
    public List<Producto> Nombre(String descripcion);
    public List<Producto> queryExitencia(double existenciasMin, double existenciasMax);
    
}
