package com.example.repostiory;

import com.example.domain.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yichuan
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
