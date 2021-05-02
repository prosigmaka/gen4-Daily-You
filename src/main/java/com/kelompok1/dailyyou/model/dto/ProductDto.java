package com.kelompok1.dailyyou.model.dto;

import com.kelompok1.dailyyou.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
public class ProductDto {
    private Integer id;
    private  String productName;
    private  Integer stock;
    private  Double price;
    private  String pictureUrl;
    private  Integer idCategory;
    private  String categoryName;

    public ProductDto(Product product) {
        this.setId(product.getId());
        this.setProductName(product.getProductName());
        this.setPictureUrl(product.getPictureUrl());
        this.setStock(product.getStock());
        this.setPrice(product.getPrice());
        this.setIdCategory(product.getProductCategory().getId());
        this.setCategoryName(product.getProductCategory().getCategoryName());
    }

    public ProductDto( String productName,  String pictureUrl, int stock,  double price,  int idCategory,  String categoryName) {
        this.productName = productName;
        this.pictureUrl = pictureUrl;
        this.stock= stock;
        this.price = price;
        this.idCategory = idCategory;
        this.categoryName= categoryName;
    }

    public ProductDto() {
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getProductName() {
//        return productName;
//    }
//
//    public void setProductName(String productName) {
//        this.productName = productName;
//    }
//
//    public Integer getStock() {
//        return stock;
//    }
//
//    public void setStock(Integer stock) {
//        this.stock = stock;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getPictureUrl() {
//        return pictureUrl;
//    }
//
//    public void setPictureUrl(String pictureUrl) {
//        this.pictureUrl = pictureUrl;
//    }
//
//    public Integer getIdCategory() {
//        return idCategory;
//    }
//
//    public void setIdCategory(Integer idCategory) {
//        this.idCategory = idCategory;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }

}