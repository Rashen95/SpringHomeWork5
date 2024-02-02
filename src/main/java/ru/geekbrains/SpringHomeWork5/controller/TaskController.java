package ru.geekbrains.SpringHomeWork5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SpringHomeWork5.dto.TaskDTO;
import ru.geekbrains.SpringHomeWork5.entity.Task;
import ru.geekbrains.SpringHomeWork5.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> allTasks() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/bystatus")
    public ResponseEntity<List<Task>> tasksByStatus(@RequestParam("status") Task.Status status) {
        return new ResponseEntity<>(taskService.getByStatus(status), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody TaskDTO dto) {
        return new ResponseEntity<>(taskService.add(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable long id, @RequestParam("status") Task.Status newStatus) {
        return new ResponseEntity<>(taskService.changeStatus(id, newStatus), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTask(@PathVariable long id) {
        taskService.deleteById(id);
        return HttpStatus.OK;
    }
}