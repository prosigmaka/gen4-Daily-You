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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_product_seq")

    @Column(name = "id_product")
    private Integer id;

    private @NotNull String productName;

    private @NotNull Integer stock;

    private @NotNull Double price;

    private @NotNull String pictureUrl;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false, nullable = false)
    private ProductCategory productCategory;

    @Column(name = "id_product_category", nullable = false)
    private Integer idCategory;

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

