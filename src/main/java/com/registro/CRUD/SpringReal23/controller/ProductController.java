/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.CRUD.SpringReal23.controller;

import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author victo
 */@Controller 
    @RequestMapping("/products")
    
public class ProductController {
   
     @Autowired
     private ProductService productService;
     
     @GetMapping
     public String listarProducts(Model model){
         model.addAttribute("product", new Product());
        return "product-form";
     } 
     @GetMapping("/nuevo")
     public String mostrarFormularioNuevoProduct(Model model){
         model.addAttribute("product", new Product());
         return "product-form";
     }
             
     @PostMapping
     public String guardarProduct(Product product) {
         productService.guardar(product);
         return "redirect:/products";
     }
     
     @GetMapping("/editar/{id}")
     public String mostrarFormularioEditarProduct(@PathVariable Long id, Model model){
         model.addAttribute("product", productService.obtenerPorId(id));
         return "product-form";
     }
 
     @GetMapping("/eliminar/{id}")
     public String eliminarProduct(@PathVariable Long id) {
        productService.eliminar(id);
        return "redirect:/product";
     }
 }
