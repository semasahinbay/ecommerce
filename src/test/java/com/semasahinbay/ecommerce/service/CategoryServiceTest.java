package com.semasahinbay.ecommerce.service;

import com.semasahinbay.ecommerce.dto.CategoryResponseDto;
import com.semasahinbay.ecommerce.entity.Category;
import com.semasahinbay.ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCategories_shouldReturnCategoryList() {

        Category category1 = new Category(1L, "C1", "Category1", "img1.jpg", 5, 'M', null);
        Category category2 = new Category(2L, "C2", "Category2", "img2.jpg", 4, 'F', null);


        try (MockedStatic<CategoryService> mocked = mockStatic(CategoryService.class)) {
            when(categoryRepository.findAll()).thenReturn(List.of(category1, category2));
            List<CategoryResponseDto> categories = categoryService.getAllCategories();
            assertEquals(2, categories.size());
            assertEquals("category1", categories.get(0).title());
        }
    }
}
