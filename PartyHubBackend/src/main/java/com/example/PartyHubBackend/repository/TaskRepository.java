package com.example.PartyHubBackend.repository;

import com.example.PartyHubBackend.repository.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
