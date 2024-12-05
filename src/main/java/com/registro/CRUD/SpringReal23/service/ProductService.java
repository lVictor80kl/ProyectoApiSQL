package com.registro.CRUD.SpringReal23.service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.repository.ProductRepository;
import java.util.ArrayList;
import org.hibernate.Hibernate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

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

    public List<Product> guardarTodos(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product obtenerPorId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }

public Product editar(Product product, Long id) {
    Product existingProduct = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    
    // Crear una nueva instancia de Product con los cambios
    Product updatedProduct = new Product();
    BeanUtils.copyProperties(product, updatedProduct);
    
    // Actualizar dimensiones si es necesario
    if (product.getDimensions() != null && updatedProduct.getDimensions() != null) {
        BeanUtils.copyProperties(product.getDimensions(), updatedProduct.getDimensions());
    }
    
    // Actualizar meta si es necesario
    if (product.getMeta() != null && updatedProduct.getMeta() != null) {
        BeanUtils.copyProperties(product.getMeta(), updatedProduct.getMeta());
    }
    
    // Manejar colecciones relajadas
    Hibernate.initialize(updatedProduct.getReviews());
    
    // Reemplazar las reseñas existentes con las nuevas
    updatedProduct.setReviews(new ArrayList<>(product.getReviews()));
    
    // Guardar el producto actualizado
    return productRepository.saveAndFlush(updatedProduct);
}

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        
        return emptyNames.toArray(new String[0]);
    }
}