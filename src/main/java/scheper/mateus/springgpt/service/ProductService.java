package scheper.mateus.springgpt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scheper.mateus.springgpt.dto.ProductDTO;
import scheper.mateus.springgpt.entity.Product;
import scheper.mateus.springgpt.exception.ResourceNotFoundException;
import scheper.mateus.springgpt.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productDTO.toProduct();
        product = productRepository.save(product);
        return ProductDTO.fromProduct(product);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        if (productDTO.getIdProduct() == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Product product = productRepository.findById(productDTO.getIdProduct())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        product.updateProduct(productDTO);
        product = productRepository.save(product);
        return ProductDTO.fromProduct(product);
    }

    public void deleteProduct(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::fromProduct).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        Product product = productRepository.findById(id).orElse(null);
        return product != null ? ProductDTO.fromProduct(product) : null;
    }
}



