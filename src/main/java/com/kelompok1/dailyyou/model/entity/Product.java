package com.kelompok1.dailyyou.model.entity;

import com.kelompok1.dailyyou.model.dto.ProductDto;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name= Product.TABLE_NAME)
@Data
public class Product {
    public static final String TABLE_NAME = "t_product";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotNull String productName;

    private @NotNull Integer stock;

    private @NotNull Double price;

    private @NotNull String pictureUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category",  nullable = false)
     ProductCategory productCategory;


    public Product(ProductDto productDto, ProductCategory productCategory) {
        this.productName = productDto.getProductName();
        this.stock = productDto.getStock();
        this.price = productDto.getPrice();
        this.pictureUrl=productDto.getPictureUrl();
        this.productCategory = productCategory;
    }

    public Product(String productName, int stock, String pictureUrl, double price, ProductCategory productCategory) {
        super();
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.pictureUrl=pictureUrl;
        this.productCategory = productCategory;
    }
    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", stock='" + stock + '\'' +
                ", price=" + price + '\'' +
                ", pictureURL='" + pictureUrl + '\'' +
                '}';
    }
}

