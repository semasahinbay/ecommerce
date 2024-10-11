package com.semasahinbay.ecommerce.util;

import com.semasahinbay.ecommerce.entity.Product;
import com.semasahinbay.ecommerce.dto.ProductResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDtoConversion {

    public static ProductResponseDto convertProduct(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getImage(),
                CategoryDtoConversion.convertCategory(product.getCategory())
        );
    }

    public static List<ProductResponseDto> convertProductList(List<Product> products) {
        return products.stream()
                .map(ProductDtoConversion::convertProduct)
                .collect(Collectors.toList());
    }
}
