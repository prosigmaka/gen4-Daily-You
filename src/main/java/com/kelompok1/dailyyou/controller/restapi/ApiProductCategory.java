package com.kelompok1.dailyyou.controller.restapi;


import com.kelompok1.dailyyou.model.entity.ProductCategory;
import com.kelompok1.dailyyou.service.ProductCategoryService;
import com.kelompok1.dailyyou.util.exception.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/productcategory")
public class ApiProductCategory {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/")
    public ResponseEntity<List<ProductCategory>> getProductCategories() {
        List<ProductCategory> body = productCategoryService.listProductCategories();
        return new ResponseEntity<List<ProductCategory>>(body, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProductCategory(@Valid @RequestBody ProductCategory productCategory) {
        if (Helper.notNull(productCategoryService.readProductCategory(productCategory.getCategoryName()))) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category already exists"), HttpStatus.CONFLICT);
        }
        productCategoryService.createProductCategory(productCategory);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "created the category"), HttpStatus.CREATED);
    }

//    TODO create an UPDATE method Giridhar

    @PostMapping("/update/{idCategory}")
    public ResponseEntity<ApiResponse> updateProductCategory(@PathVariable("idCategory") int idCategory, @Valid @RequestBody ProductCategory productCategory) {
        // Check to see if the category exists.
        if (Helper.notNull(productCategoryService.readProductCategory(idCategory))) {
            // If the category exists then update it.
            productCategoryService.updateProductCategory(idCategory, productCategory);
            return new ResponseEntity<ApiResponse>(new ApiResponse(true, "updated the category"), HttpStatus.OK);
        }

        // If the category doesn't exist then return a response of unsuccessful.
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"), HttpStatus.NOT_FOUND);
    }
}
