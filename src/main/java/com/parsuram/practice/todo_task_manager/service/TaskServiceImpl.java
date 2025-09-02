package com.parsuram.practice.todo_task_manager.service;

import com.parsuram.practice.todo_task_manager.Entity.Task;
import com.parsuram.practice.todo_task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    // Constructor injection
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id).map(task -> {
            if (taskDetails.getTitle() != null) task.setTitle(taskDetails.getTitle());
            if (taskDetails.getDescription() != null) task.setDescription(taskDetails.getDescription());
            // Update completed flag
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
