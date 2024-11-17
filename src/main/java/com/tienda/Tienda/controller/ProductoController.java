/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Tienda.controller;

/**
 *
 * @author Fabian Vargas
 */
import com.tienda.Tienda.domain.Producto;
import com.tienda.Tienda.service.CategoriaService;
import com.tienda.Tienda.service.ProductoService;
import com.tienda.Tienda.service.impl.FireBaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
      var lista=productoService.getProductos(false);
      model.addAttribute("productos", lista);
      
      var categorias = categoriaService.getCategorias(true);
      model.addAttribute("categorias", categorias);
      
      model.addAttribute("TotalProductos", lista.size());
      return "/producto/listado";
    }
    
        @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    @Autowired
    private FireBaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
          var categorias = categoriaService.getCategorias(false);
      model.addAttribute("categorias", categorias);
        return "/producto/modifica";
    }
    
     @PostMapping("/query3")
    public String consultaQuery3(@RequestParam(value = "descripcion") String descripcion,
             Model model) {
        var productos = productoService.Nombre(descripcion);
        model.addAttribute("productos", productos);
        model.addAttribute("TotalProductos", productos.size());
        model.addAttribute("descripcion", descripcion);
        return "/producto/listado";
    }
    
     @PostMapping("/query2")
    public String consultaQuery3(@RequestParam(value = "existenciasMin") double existenciasMin,
            @RequestParam(value = "existenciasMax") double existenciasMax, Model model) {
        var productos = productoService.queryExitencia(existenciasMin, existenciasMax);
        model.addAttribute("productos", productos);
        model.addAttribute("TotalProductos", productos.size());
        model.addAttribute("existenciasMin", existenciasMin);
        model.addAttribute("existenciasMax", existenciasMax);
        return "/producto/listado";
    }
}
