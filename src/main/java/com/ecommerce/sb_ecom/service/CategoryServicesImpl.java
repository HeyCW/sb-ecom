package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Categories;
import com.ecommerce.sb_ecom.repositories.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServicesImpl implements CategoryServices{

    private long categoryId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Categories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void addCategories(Categories category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategories(long categoryId) {

        Categories category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category Not Found"));
    }

    @Override
    public void updateCategories(long categoryId, Categories category) {
        Categories updatedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));
        updatedCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(updatedCategory);
    }


}
