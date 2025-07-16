package com.codewithdurgesh.blog.services;

import com.codewithdurgesh.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {


    // Create
    CategoryDto createCategory(CategoryDto categoryDto);

    // Update
    CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId);

    // Get
    CategoryDto getCategory(Integer categoryId);

    // Get All
    List<CategoryDto> getCategories();

    // Delete
    void deleteCategory(Integer categoryId);
}
