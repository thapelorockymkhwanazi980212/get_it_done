package com.getitdone.services;

import com.getitdone.model.Task;
import com.getitdone.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    //return the list of tasks
    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    // save task
    public Task saveTask(Task task)
    {
        return taskRepository.save(task);
    }

    //get task by its id
    public Optional<Task> getTaskById(Long id)
    {
        return taskRepository.findById(id);
    }

    //delete task
    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }
}
