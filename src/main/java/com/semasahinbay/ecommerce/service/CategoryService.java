package com.semasahinbay.ecommerce.service;

import com.semasahinbay.ecommerce.dto.CategoryResponseDto;
import com.semasahinbay.ecommerce.entity.Category;
import com.semasahinbay.ecommerce.entity.Product;

import java.util.List;

public interface CategoryService{
    List<CategoryResponseDto> getAllCategories();
    CategoryResponseDto getCategoryById(Long id);
    Category getCategoryByIdOriginal(Long id);
    CategoryResponseDto saveCategory(Category category);
    CategoryResponseDto deleteCategory(Long id);
    List<Product> getProductsByCategoryId(Long categoryId);
}
