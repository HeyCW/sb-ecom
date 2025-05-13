package com.ecommerce.sb_ecom.repositories;

import com.ecommerce.sb_ecom.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories, Long> {

}
