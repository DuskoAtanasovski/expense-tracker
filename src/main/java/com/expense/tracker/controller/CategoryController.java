package com.expense.tracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.tracker.model.Category;
import com.expense.tracker.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	Collection<Category> categories() {
		return categoryRepository.findAll();
		// SELECT * FROM category
	}

	@GetMapping("/categories/{id}")
	ResponseEntity<?> getCategory(@PathVariable Long id) {
		// We use optional because the id may not be valid
		Optional<Category> category = categoryRepository.findById(id);
		// Map the category to response variable, if the ResponseEntity is OK return the
		// body with the response in it, if the ResponseEntity in not OK then return
		// NOT_FOUND
		return category.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/category")
	ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
		Category result = categoryRepository.save(category);// INSERT INTO TABLE category...
		// We create a ResponseEntity with the URI that will contain the id of the
		// category and the we will add that to the body of the Response
		return ResponseEntity.created(new URI("api/category" + result.getId())).body(result);

	}

	@PutMapping("/category/{id}")
	ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) {
		Category result = categoryRepository.save(category);// INSERT INTO TABLE category...
		// If this record already exists and the method is PUT, JPA knows that it should
		// be updated and is doing that for us
		return ResponseEntity.ok().body(result);
	}

	@DeleteMapping("/category/{id}")
	ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}