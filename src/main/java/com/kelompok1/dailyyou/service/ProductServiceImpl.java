package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.repository.ProductCategoryRepository;
import com.kelompok1.dailyyou.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;


    @Override
    public Product save(Product product) {
        product= productRepository.save(product);
        product.setProductCategory(productCategoryRepository.findById(product.getIdCategory()).get());
        return product;
    }
}
