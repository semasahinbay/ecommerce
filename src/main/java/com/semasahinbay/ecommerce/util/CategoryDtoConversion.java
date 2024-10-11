package com.semasahinbay.ecommerce.util;

import com.semasahinbay.ecommerce.entity.Category;
import com.semasahinbay.ecommerce.dto.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDtoConversion {

    public static CategoryResponseDto convertCategory(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getCode(),
                category.getTitle(),
                category.getImage(),
                category.getRating(),
                category.getGender());
    }

    public static List<CategoryResponseDto> convertCategoryList(List<Category> categories) {
        List<CategoryResponseDto> categoryResponses = new ArrayList<>();
        categories.forEach(category ->
                categoryResponses.add(new CategoryResponseDto(
                        category.getId(),
                        category.getCode(),
                        category.getTitle(),
                        category.getImage(),
                        category.getRating(),
                        category.getGender())));
        return categoryResponses;
    }
}
