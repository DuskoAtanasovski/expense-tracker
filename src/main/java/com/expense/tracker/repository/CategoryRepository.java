package com.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByName(String name);
}
