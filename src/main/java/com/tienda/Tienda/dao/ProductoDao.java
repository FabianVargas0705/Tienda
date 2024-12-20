/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Tienda.dao;

import com.tienda.Tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Fabian Vargas
 */
public interface ProductoDao extends JpaRepository<Producto,Long> {
    
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    
    //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
    
    //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery=true,
            value="SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup); 
    
     @Query(nativeQuery = true,
       value = "SELECT * FROM producto WHERE descripcion LIKE CONCAT('%', :descricion, '%') ORDER BY producto.descripcion ASC")
public List<Producto> Nombre(@Param("descricion") String descricion);

@Query(nativeQuery=true,
            value="SELECT * FROM producto where existencias BETWEEN :existenciasMin AND :existenciasMax ORDER BY producto.descripcion ASC")
    public List<Producto> queryExitencia(@Param("existenciasMin") double existenciasMin, @Param("existenciasMax") double existenciasMax); 
    

}
