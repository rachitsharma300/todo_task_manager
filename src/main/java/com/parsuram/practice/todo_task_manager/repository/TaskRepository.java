package com.parsuram.practice.todo_task_manager.repository;

import com.parsuram.practice.todo_task_manager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // future custom queries here
}
