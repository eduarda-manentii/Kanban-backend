package com.br.kanban.estruturas;

import java.util.ArrayList;
import java.util.List;

import com.br.kanban.model.Task;

public class FilaPrioridadeTask {

    private TaskNode inicio;
    private TaskNode fim;

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(TaskNode e) {
        if (isEmpty()) {
            inicio = e;
            fim = e;
        } else {
            if (inicio.tarefa.getPriority() < e.tarefa.getPriority()) {
                e.proximo = inicio;
                inicio = e;
            } else {
                if (fim.tarefa.getPriority() >= e.tarefa.getPriority()) {
                    fim.proximo = e;
                    fim = e;
                } else {
                    TaskNode aux = inicio;
                    while(aux.proximo != null && aux.proximo.tarefa.getPriority() >= e.tarefa.getPriority()) {
                        aux = aux.proximo;
                    }
                    e.proximo = aux.proximo;
                    aux.proximo = e;
                }
            }
        }
    }

    public Task dequeue() {
        if(!isEmpty()) {
            Task t = inicio.tarefa;
            inicio = inicio.proximo;
            if(inicio == null) {
                fim = null;
            }
            return t;
        }
        return null;
    }

    public List<Task> toList() {
        List<Task> lista = new ArrayList<>();
        TaskNode aux = inicio;
        while (aux != null) {
            lista.add(aux.tarefa);
            aux = aux.proximo;
        }
        return lista;
    }

}
