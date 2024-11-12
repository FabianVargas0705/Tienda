/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.Tienda.service;

import com.tienda.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author Fabian Vargas
 */
public interface CategoriaService {
    
    //El siguiente Metodo retorna una lista con las categorias
    // que estan en las tabla arbol, todas o solo las activas
    public List<Categoria> getCategorias(boolean activos);
    
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Categoria getCategoria(Categoria categoria);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Categoria categoria);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Categoria categoria);
    
}
