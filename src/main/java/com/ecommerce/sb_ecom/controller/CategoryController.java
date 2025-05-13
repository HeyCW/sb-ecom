package com.ecommerce.sb_ecom.controller;

import com.ecommerce.sb_ecom.model.Categories;
import com.ecommerce.sb_ecom.service.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping("api/public/categories")
    public ResponseEntity<List<Categories>> getAllCategories(){
        return new ResponseEntity<>(categoryServices.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("api/public/add-category")
    public ResponseEntity<String> addCategory(@RequestBody Categories category){
        categoryServices.addCategories(category);
        return new ResponseEntity<>("Category added successfuully",HttpStatus.OK);
    }

    @DeleteMapping("api/public/delete-category/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId){

        try {
            categoryServices.deleteCategories(categoryId);
            return new ResponseEntity<>("Category deleted successfully", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("app/pubulic/update-category/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Categories category, @PathVariable long categoryId){
        try {
            categoryServices.updateCategories(categoryId, category);
            return new ResponseEntity<>("Category updated successfully", HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }


}
