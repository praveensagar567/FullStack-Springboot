package com.BDIplus.service;

import com.BDIplus.model.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}

