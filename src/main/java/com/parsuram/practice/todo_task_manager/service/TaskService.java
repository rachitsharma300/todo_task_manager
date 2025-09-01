package com.parsuram.practice.todo_task_manager.service;

import com.parsuram.practice.todo_task_manager.Entity.Task;

import java.util.List;
import java.util.Optional;

/**
 * TaskService contains business logic contract for managing tasks.
 *
 * - Controller will call methods from this service.
 * - Implementation will be done in TaskServiceImpl.
 */
public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Task updateTask(Long id, Task taskDetails);

    void deleteTask(Long id);
}
