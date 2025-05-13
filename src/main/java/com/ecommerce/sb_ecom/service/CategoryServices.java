package com.ecommerce.sb_ecom.service;

import com.ecommerce.sb_ecom.model.Categories;

import java.util.List;

public interface CategoryServices {

    List<Categories> getAllCategories();
    void addCategories(Categories category);
    void deleteCategories(long categoryId);
    void updateCategories(long categoryId, Categories category);

}
