package ru.geekbrains.SpringHomeWork5.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.SpringHomeWork5.dto.TaskDTO;
import ru.geekbrains.SpringHomeWork5.entity.Task;
import ru.geekbrains.SpringHomeWork5.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task add(TaskDTO dto) {
        return taskRepository.save(new Task(dto.getDescription()));
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> getByStatus(Task.Status status) {
        return taskRepository.findByStatus(status);
    }

    public Task changeStatus(long id, Task.Status newStatus) {
        Task t = taskRepository.findById(id).orElseThrow();
        t.setStatus(newStatus);
        taskRepository.save(t);
        return t;
    }

    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}