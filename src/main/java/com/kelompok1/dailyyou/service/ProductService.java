package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.Product;

import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Product getProductById(Integer productId);
}
