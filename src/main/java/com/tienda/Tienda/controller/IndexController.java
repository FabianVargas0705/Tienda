/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.Tienda.controller;

import com.tienda.Tienda.service.CategoriaService;
import com.tienda.Tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Fabián Vargas
 */
@Controller
@RequestMapping("/")
public class IndexController {
     @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public String index(Model model) {
        // Obtener lista de productos y categorías
        var listaProductos = productoService.getProductos(false);
        var listaCategorias = categoriaService.getCategorias(true);

        // Agregar datos al modelo
        model.addAttribute("productos", listaProductos);
        model.addAttribute("categorias", listaCategorias);
        model.addAttribute("TotalProductos", listaProductos.size());

        // Retornar la plantilla del index
        return "index";
    }
}
