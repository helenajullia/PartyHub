package com.example.PartyHubBackend.repository;

import com.example.PartyHubBackend.repository.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
