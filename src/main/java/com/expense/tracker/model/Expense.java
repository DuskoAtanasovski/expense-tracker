package com.expense.tracker.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "expense")
public class Expense {

	@Id
	private Long id;
	
	private Instant expensedate;
	
	private String description;
	
	@ManyToOne
	private Category category;
	
	@ManyToOne
	private User user;
}
