package com.br.kanban.estruturas;

import com.br.kanban.model.Task;

public class TaskNode {
    public Task tarefa;
    public TaskNode proximo;

    public TaskNode(Task tarefa) {
        this.tarefa = tarefa;
        this.proximo = null;
    }
    
}
