package ru.geekbrains.SpringHomeWork5.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks", schema = "tasks_schema")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String description;
    @NonNull
    private Status status;
    @NonNull
    private LocalDateTime dateOfCreation;

    public Task() {
    }

    public Task(@NonNull String description) {
        this.description = description;
        this.status = Status.NOT_STARTED;
        this.dateOfCreation = LocalDateTime.now();
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }

    public void setStatus(@NonNull Status status) {
        this.status = status;
    }

    @NonNull
    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public enum Status {
        NOT_STARTED,
        IN_PROGRESS,
        DONE
    }
}