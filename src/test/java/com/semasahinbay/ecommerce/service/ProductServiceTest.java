package com.semasahinbay.ecommerce.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.semasahinbay.ecommerce.dto.ProductResponseDto;
import com.semasahinbay.ecommerce.entity.Product;
import com.semasahinbay.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.List;

class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllProducts_shouldReturnProductList() {

        Product product1 = new Product(1L, "Product1", "Description1", 10.0, 100, 4.5, 20, "image1.jpg", null, null, null);
        Product product2 = new Product(2L, "Product2", "Description2", 20.0, 200, 3.5, 50, "image2.jpg", null, null, null);

        when(productRepository.findAll()).thenReturn(List.of(product1, product2));

        List<ProductResponseDto> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals("Product1", products.get(0).name());
        assertEquals("Product2", products.get(1).name());

    }
}
