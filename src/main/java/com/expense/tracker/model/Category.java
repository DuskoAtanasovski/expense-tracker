package com.expense.tracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NoArgsConstructor
@Data
@Table(name = "category")
public class Category {

	@Id
	private Long id;

	@NonNull
	// Travel, Grocery, ...
	private String name;

}
