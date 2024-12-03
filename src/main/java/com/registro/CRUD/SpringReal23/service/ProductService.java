package com.registro.CRUD.SpringReal23.service;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.repository.ProductRepository;
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
        
        BeanUtils.copyProperties(product, existingProduct, getNullPropertyNames(product));
        
        if (product.getDimensions() != null && existingProduct.getDimensions() != null) {
            BeanUtils.copyProperties(product.getDimensions(), existingProduct.getDimensions());
        }
        
        if (product.getMeta() != null && existingProduct.getMeta() != null) {
            BeanUtils.copyProperties(product.getMeta(), existingProduct.getMeta());
        }
        
        if (product.getReviews() != null) {
            existingProduct.getReviews().clear();
            existingProduct.getReviews().addAll(product.getReviews());
        }
        
        return productRepository.save(existingProduct);
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