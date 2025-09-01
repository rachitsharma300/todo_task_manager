package com.parsuram.practice.todo_task_manager.controller;


import com.parsuram.practice.todo_task_manager.Entity.Task;
import com.parsuram.practice.todo_task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TaskController handles incoming HTTP requests.
 * - Maps API endpoints to corresponding service methods.
 * - Works as a bridge between the frontend (client) and service layer.
 */
@RestController
@RequestMapping("/tasks") // Base URL for all APIs → http://localhost:8080/tasks
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Create a new task
     * Endpoint: POST /tasks
     * Body Example: { "title": "Learn Spring Boot", "description": "Practice daily", "completed": false }
     */
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }

    /**
     * Get all tasks
     * Endpoint: GET /tasks
     */
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    /**
     * Get a task by ID
     * Endpoint: GET /tasks/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Update a task by ID
     * Endpoint: PUT /tasks/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Optional<Task> existingTask = taskService.getTaskById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return ResponseEntity.ok(taskService.saveTask(task));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a task by ID
     * Endpoint: DELETE /tasks/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

