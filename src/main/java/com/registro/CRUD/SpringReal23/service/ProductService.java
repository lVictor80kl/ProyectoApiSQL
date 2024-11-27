/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registro.CRUD.SpringReal23.service;

import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> listarTodas() {
        return productRepository.findAll();
    }

    public Product guardar(Product product) {
        return productRepository.save(product);
    }

    public Product obtenerPorId(Long id) {
        return productRepository.findById(id).orElse(null);   
    }

    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }

    public Product editar(Product product) {
        if (product.getId() == null) {
            return null; // Cannot edit a product without an ID
        }
        
        Optional<Product> existingProduct = productRepository.findById(product.getId());
        
        if (existingProduct.isPresent()) {
            // Update the existing product with the new data
            Product updatedProduct = existingProduct.get();
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDiscountPercentage(product.getDiscountPercentage());
            updatedProduct.setRating(product.getRating());
            updatedProduct.setStock(product.getStock());
            updatedProduct.setBrand(product.getBrand());
            updatedProduct.setSku(product.getSku());
            updatedProduct.setWeight(product.getWeight());
            updatedProduct.setDimensions(product.getDimensions());
            updatedProduct.setWarrantyInformation(product.getWarrantyInformation());
            updatedProduct.setShippingInformation(product.getShippingInformation());
            updatedProduct.setAvailabilityStatus(product.getAvailabilityStatus());
            updatedProduct.setReturnPolicy(product.getReturnPolicy());
            updatedProduct.setMinimumOrderQuantity(product.getMinimumOrderQuantity());
            updatedProduct.setTags(product.getTags());
            updatedProduct.setImages(product.getImages());
            updatedProduct.setThumbnail(product.getThumbnail());
            updatedProduct.setMeta(product.getMeta());
            updatedProduct.setReviews(product.getReviews());
            
            return productRepository.save(updatedProduct);
        } else {
            return null; // Product not found
        }
    }
}