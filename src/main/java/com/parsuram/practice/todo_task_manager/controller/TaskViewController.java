package com.parsuram.practice.todo_task_manager.controller;

import com.parsuram.practice.todo_task_manager.Entity.Task;
import com.parsuram.practice.todo_task_manager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/view/tasks")
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Show all tasks
    @GetMapping
    public String listTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list"; // resolves to src/main/resources/templates/task-list.html
    }

    // Show form to create a task
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form"; // resolves to task-form.html
    }

    // Handle new task form submission
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/view/tasks";
    }

    // Show form to edit an existing task
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Task> task = taskService.getTaskById(id);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "task-form"; // same form for edit
        }
        return "redirect:/view/tasks";
    }

    // Handle update task form submission
    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task taskDetails) {
        taskService.updateTask(id, taskDetails);
        return "redirect:/view/tasks";
    }

    // Delete a task
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/view/tasks";
    }
}
