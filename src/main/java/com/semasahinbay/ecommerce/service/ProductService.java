package com.semasahinbay.ecommerce.service;

import com.semasahinbay.ecommerce.dto.ProductResponseDto;
import com.semasahinbay.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProductById(Long id);
    ProductResponseDto saveProduct(Long categoryId, Product product);
    ProductResponseDto updateProduct(Long id, Product product);
    ProductResponseDto deleteProduct(Long id);
}
