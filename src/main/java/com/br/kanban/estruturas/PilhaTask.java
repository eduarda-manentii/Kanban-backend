package com.br.kanban.estruturas;

import java.util.ArrayList;
import java.util.List;

import com.br.kanban.model.Task;

public class PilhaTask {

    private TaskNode topo;

    public PilhaTask() {
        this.topo = null;
    }

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Task tarefa) {
        TaskNode novo = new TaskNode(tarefa);
        novo.proximo = topo;
        topo = novo;
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        Task tarefaTopo = topo.tarefa;
        topo = topo.proximo;
        return tarefaTopo;
    }

    public Task peek() {
        if (isEmpty()) {
            return null;
        }
        return topo.tarefa;
    }

    public List<Task> toList() {
        List<Task> lista = new ArrayList<>();
        TaskNode aux = topo;
        while (aux != null) {
            lista.add(aux.tarefa);
            aux = aux.proximo;
        }
        return lista;
    }

}
