package com.parsuram.practice.todo_task_manager.service;

import com.parsuram.practice.todo_task_manager.Entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Long id);

    Task updateTask(Long id, Task taskDetails);

    void deleteTask(Long id);
}
