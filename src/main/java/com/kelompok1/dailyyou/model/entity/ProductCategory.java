package com.kelompok1.dailyyou.model.entity;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name= ProductCategory.TABLE_NAME)
@Data
public class ProductCategory {
    public static final String TABLE_NAME = "t_product_category";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME)
    @SequenceGenerator(name = TABLE_NAME, sequenceName = "t_product_category_seq")

//    @Column(name = "id")
//    private Integer id;

    @Column(name = "id_category")
    private Integer id;

    private @NotBlank String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<Product> products;

    public ProductCategory() {
    }

    public ProductCategory(@NotBlank String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "User {category id=" + id + ", category name='" + categoryName + "'}";
    }

}

