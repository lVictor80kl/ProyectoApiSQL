/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.CRUD.SpringReal23.controller;

import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author victo
 */@RestController
    @RequestMapping("/products")
    
public class ProductController {
   
     @Autowired
     private ProductService productService;
     
     @GetMapping
public List<Product> listarProducts() {
    return productService.listarTodas();
}

@GetMapping("/nuevo")
public Product nuevoProduct() {
    return new Product();
}

@PostMapping
public Product guardarProduct(@RequestBody Product product) {
    return productService.guardar(product);
}

/*@PutMapping("/editar/{id}")
public ResponseEntity<Product> editarProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.editar(product);
    
}
*/
@DeleteMapping("/eliminar/{id}")
public ResponseEntity<Void> eliminarProduct(@PathVariable Long id) {
    try {
        productService.eliminar(id);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

 }
