package com.br.kanban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.kanban.estruturas.FilaPrioridadeTask;
import com.br.kanban.estruturas.FilaSimplesTask;
import com.br.kanban.estruturas.PilhaTask;
import com.br.kanban.estruturas.TaskNode;
import com.br.kanban.model.Task;

@Service
public class TaskService {

    private FilaPrioridadeTask backlog = new FilaPrioridadeTask();
    private FilaSimplesTask doing = new FilaSimplesTask();
    private PilhaTask done = new PilhaTask();

    public void addTaskToBacklog(Task task) {
        backlog.enqueue(new TaskNode(task));
    }

    public Task moveBacklogToDoing() {
        Task task = backlog.dequeue();
        if (task != null) {
            doing.enqueue(new TaskNode(task));
        }
        return task;
    }

    public Task moveDoingToDone() {
        Task task = doing.dequeue();
        if (task != null) {
            done.push(task);
        }
        return task;
    }

    public Task moveDoneToDoing() {
        Task task = done.pop();
        if(task != null) {
            doing.enqueue(new TaskNode(task));
        }
        return task;
    }

    public List<Task> getBacklogTasks() {
        return backlog.toList();
    }

    public List<Task> getDoingTasks() {
        return doing.toList();
    }

    public List<Task> getDoneTasks() {
        return done.toList();
    }

}
