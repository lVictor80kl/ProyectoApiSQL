package com.registro.CRUD.SpringReal23.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.CRUD.SpringReal23.model.Product;
import com.registro.CRUD.SpringReal23.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Listar todos los productos
    public List<Product> listarTodas() {
        return productRepository.findAll();
    }

    // Guardar un solo producto
    public Product guardar(Product product) {
        return productRepository.save(product);
    }

    // Guardar múltiples productos
    public List<Product> guardarTodos(List<Product> products) {
        return productRepository.saveAll(products);
    }

    // Obtener un producto por su ID
    public Product obtenerPorId(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Eliminar un producto por su ID
    public void eliminar(Long id) {
        productRepository.deleteById(id);
    }
}


/*public Product editar(Product product, Long id) {
    // Buscar el producto antiguo por id
    Product oldProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));

    // Actualizar los valores del producto antiguo con los valores del nuevo producto
    oldProduct.setTitle(product.getTitle());
    oldProduct.setDescription(product.getDescription());
    oldProduct.setCategory(product.getCategory());
    oldProduct.setPrice(product.getPrice());
    oldProduct.setDiscountPercentage(product.getDiscountPercentage());
    oldProduct.setRating(product.getRating());
    oldProduct.setStock(product.getStock());
    oldProduct.setBrand(product.getBrand());
    oldProduct.setSku(product.getSku());
    oldProduct.setWeight(product.getWeight());

    // Actualizar las dimensiones
    if (product.getDimensions() != null) {
        Dimensions oldDimensions = oldProduct.getDimensions();
        Dimensions newDimensions = product.getDimensions();
        oldDimensions.setWidth(newDimensions.getWidth());
        oldDimensions.setHeight(newDimensions.getHeight());
        oldDimensions.setDepth(newDimensions.getDepth());
    }

    oldProduct.setWarrantyInformation(product.getWarrantyInformation());
    oldProduct.setShippingInformation(product.getShippingInformation());
    oldProduct.setAvailabilityStatus(product.getAvailabilityStatus());
    oldProduct.setReturnPolicy(product.getReturnPolicy());
    oldProduct.setMinimumOrderQuantity(product.getMinimumOrderQuantity());
    oldProduct.setTags(product.getTags());
    oldProduct.setImages(product.getImages());
    oldProduct.setThumbnail(product.getThumbnail());

    // Actualizar meta
    if (product.getMeta() != null) {
        Meta oldMeta = oldProduct.getMeta();
        Meta newMeta = product.getMeta();
        oldMeta.setCreatedAt(newMeta.getCreatedAt());
        oldMeta.setUpdatedAt(newMeta.getUpdatedAt());
        oldMeta.setBarcode(newMeta.getBarcode());
        oldMeta.setQrCode(newMeta.getQrCode());
    }

    // Actualizar las reviews
    if (product.getReviews() != null) {
        List<Review> newReviews = product.getReviews();
        List<Review> oldReviews = oldProduct.getReviews();
        oldReviews.clear();
        oldReviews.addAll(newReviews);
    }

    // Guardar el producto actualizado en el repositorio
    return productRepository.save(oldProduct);
}
*/
 