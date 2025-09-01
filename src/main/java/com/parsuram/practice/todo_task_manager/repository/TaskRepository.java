package com.parsuram.practice.todo_task_manager.repository;

import com.parsuram.practice.todo_task_manager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TaskRepository is the Data Access Layer for Task entity.
 *
 * - It extends JpaRepository which provides ready-made CRUD operations:
 *   save(), findById(), findAll(), deleteById(), etc.
 *
 * - We don’t need to write SQL queries manually for common operations.
 * - If needed, we can also define custom query methods here later.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Example of a custom finder method (not required now, but useful later):
    // List<Task> findByStatus(String status);
}
