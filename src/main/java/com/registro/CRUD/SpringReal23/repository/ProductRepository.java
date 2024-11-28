/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.registro.CRUD.SpringReal23.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.CRUD.SpringReal23.model.Product;

/**
 *
 * @author victor
 */
public interface ProductRepository extends JpaRepository <Product, Long> {
    
}
