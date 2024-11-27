/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registro.CRUD.SpringReal23.repository;

import com.registro.CRUD.SpringReal23.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author victo
 */
public interface ProductRepository extends JpaRepository <Product, Long> {
    
}
