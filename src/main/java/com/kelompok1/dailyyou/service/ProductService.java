package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.configuration.exception.ProductNotExistException;
import com.kelompok1.dailyyou.model.dto.ProductDto;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.ProductCategory;
import com.kelompok1.dailyyou.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }
    public List<ProductDto> listProductByCategory(Integer id) {
        List<Product> products = productRepository.cariProductCategory(id);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public List<ProductDto> searchProduct(String search) {
        List<Product> products = productRepository.searchProduct(search);
        List<ProductDto> productDtos = new ArrayList<>();
        for(Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }

    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    public static Product getProductFromDto(ProductDto productDto, ProductCategory productCategory) {
        Product product = new Product(productDto, productCategory);
        return product;
    }

    public void addProduct(ProductDto productDto, ProductCategory productCategory) {
        Product product = getProductFromDto(productDto, productCategory);
        productRepository.save(product);
    }

    public void updateProduct(Integer idProduct, ProductDto productDto, ProductCategory productCategory) {
        Product product = getProductFromDto(productDto, productCategory);
        product.setId(idProduct);
        productRepository.save(product);
    }

    public Product getProductById(Integer productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }
}
