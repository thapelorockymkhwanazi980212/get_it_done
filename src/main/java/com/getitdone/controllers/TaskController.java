package com.getitdone.controllers;

import com.getitdone.model.Task;
import com.getitdone.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping //get all tasks
    public List<Task> getAllTasks()
    {
        return taskService.getAllTasks();
    }

    // create a task
    @PostMapping
    public Task createTask(Task task)
    {
        return taskService.saveTask(task);
    }

    //get specific task
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.saveTask(task);
    }

    //remove task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
