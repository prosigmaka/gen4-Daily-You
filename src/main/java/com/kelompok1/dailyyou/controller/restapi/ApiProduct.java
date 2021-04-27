//package com.kelompok1.dailyyou.controller.restapi;
//
//import com.kelompok1.dailyyou.model.dto.ProductDto;
//import com.kelompok1.dailyyou.model.entity.Product;
//import com.kelompok1.dailyyou.repository.ProductRepository;
//import com.kelompok1.dailyyou.service.ProductService;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/api/product")
//public class ApiProduct {
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    ModelMapper modelMapper;
//
//    @Autowired
//    ProductService productService;
//
//
//    @GetMapping()
//    public List<ProductDto> getListProduct() {
//        List<Product> productList = productRepository.findAll();
//        List<ProductDto> productDtos =
//                productList.stream()
//                        .map(product -> mapProductToProductDto(product))
//                        .collect(Collectors.toList());
//        return productDtos;
//    }
//
//    private ProductDto mapProductToProductDto(Product product) {
//        ProductDto productDto = modelMapper.map(product, ProductDto.class);
//        modelMapper.map(product.getProductCategory(), productDto);
//        productDto.setIdCategory(product.getProductCategory().getId());
//
//        productDto.setId(product.getId());
//        return productDto;
//    }
//
//    @GetMapping("/{id}")
//    public ProductDto getProduct(@PathVariable Integer id) {
//        Product product = productRepository.findById(id).get();
//        ProductDto productDto = new ProductDto();
//        modelMapper.map(product, productDto);
//        modelMapper.map(product.getProductCategory(), productDto);
//
//        return productDto;
//    }
//
//    @PostMapping
//    public ProductDto editsaveProduct(@RequestBody ProductDto productDto) {
//        Product product = modelMapper.map(productDto, Product.class);
//        product.setIdCategory(productDto.getIdCategory());
//        product.setId(productDto.getId());
//        product= productService.save(product);
//        ProductDto productDtoDB =mapProductToProductDto(product);
//
//        return productDtoDB;
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id) {
//        productRepository.deleteById(id);
//    }
//
//}
