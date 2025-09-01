package com.parsuram.practice.todo_task_manager.Entity;

import jakarta.persistence.*; // For JPA annotations
import java.time.LocalDateTime;

/**
 * This is the Entity class (Model layer).
 * It directly maps to the Database table "tasks".
 * Each object of Task will represent one row in the database.
 */
@Entity                  // Marks this class as a JPA entity (table in DB)
@Table(name = "tasks")   // Optional: specify custom table name
public class Task {

    @Id  // Marks primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto-increment ID in database
    private Long id;

    @Column(nullable = false)
    // Cannot be NULL in DB
    private String title;

    private String description;

    @Column(nullable = false)
    private String status; // Example: "Pending", "In Progress", "Completed"

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ---------------- Constructors ----------------

    public Task() {
        // Default constructor (needed by JPA)
    }

    public Task(String title, String description, String status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // ---------------- Getters and Setters ----------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ---------------- toString() for debugging ----------------
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
