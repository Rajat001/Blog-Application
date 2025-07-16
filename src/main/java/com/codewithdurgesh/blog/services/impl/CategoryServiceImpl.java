package com.codewithdurgesh.blog.services.impl;

import com.codewithdurgesh.blog.entities.Category;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.CategoryDto;
import com.codewithdurgesh.blog.repositories.CategoryRepo;
import com.codewithdurgesh.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category createCategory = this.modelMapper.map(categoryDto , Category.class);
        Category addedCat = this.categoryRepo.save(createCategory);
        return this.modelMapper.map(addedCat , CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category updateCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException(" Category " , " Id " , categoryId));
        Category saveCategory = this.modelMapper.map(categoryDto , Category.class);
        Category finalSaveCategory = this.categoryRepo.save(saveCategory);
        return this.modelMapper.map(finalSaveCategory , CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category getCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category " , " Id " , categoryId));
        return this.modelMapper.map(getCategory , CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> catDtos =  categories.stream().map((cat)->modelMapper.map(cat,CategoryDto.class)).collect((Collectors.toList()));
        return catDtos;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category getCategory = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category id " , " Id " , categoryId));
        this.categoryRepo.delete(getCategory);
    }
}
