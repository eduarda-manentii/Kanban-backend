package com.br.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.kanban.model.Task;
import com.br.kanban.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/backlog")
    public void addTaskToBacklog(@RequestBody Task task) {
        taskService.addTaskToBacklog(task);
    }

    @PostMapping("/move/backlog-to-doing")
    public Task moveBacklogToDoing() {
        return taskService.moveBacklogToDoing();
    }

    @PostMapping("/move/doing-to-done")
    public Task moveDoingToDone() {
        return taskService.moveDoingToDone();
    }
    @PostMapping("/move/done-to-doing")
    public Task moveDoneToDoing() {
        return taskService.moveDoneToDoing();
    }

    @GetMapping("/backlog")
    public List<Task> getBacklogTasks() {
        return taskService.getBacklogTasks();
    }

    @GetMapping("/doing")
    public List<Task> getDoingTasks() {
        return taskService.getDoingTasks();
    }

    @GetMapping("/done")
    public List<Task> getDoneTasks() {
        return taskService.getDoneTasks();
    }
    
}