package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.model.entity.ProductCategory;
import com.kelompok1.dailyyou.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> listProductCategories() {
        return productCategoryRepository.findAll();
    }

    public void createProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public ProductCategory readProductCategory(String categoryName) {
        return productCategoryRepository.findByCategoryName(categoryName);
    }

    public Optional<ProductCategory> readProductCategory(Integer idCategory) {
        return productCategoryRepository.findById(idCategory);
    }

    public void updateProductCategory(Integer idCategory, ProductCategory newProductCategory) {
        ProductCategory productCategory = productCategoryRepository.findById(idCategory).get();
        productCategory.setCategoryName(newProductCategory.getCategoryName());
        productCategory.setProducts(newProductCategory.getProducts());


        productCategoryRepository.save(productCategory);
    }
}
