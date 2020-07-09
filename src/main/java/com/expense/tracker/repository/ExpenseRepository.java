package com.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.tracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
