package com.BDIplus.controller;

import com.BDIplus.model.Task;
import com.BDIplus.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class TaskController {

    Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public Task newTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    @ApiOperation("Returns tasks based on id ")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@RequestBody Task newTask, @PathVariable Long id) {
        return taskService.updateTask(id, newTask);
    }

    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task with id " + id + " has been deleted successfully.";
    }
}
