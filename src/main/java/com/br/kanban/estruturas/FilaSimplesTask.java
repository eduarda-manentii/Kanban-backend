package com.br.kanban.estruturas;

import java.util.ArrayList;
import java.util.List;

import com.br.kanban.model.Task;

public class FilaSimplesTask {

    TaskNode primeiroItem;
	TaskNode ultimoItem;
	
	public boolean isEmpty() {
		return this.primeiroItem == null && this.ultimoItem == null;
	}
	
	public void enqueue(TaskNode e) {
		if(isEmpty()) {
			primeiroItem = e;
			ultimoItem = e;
		} else {
			ultimoItem.proximo = e;
			ultimoItem = e;
		}
	}
	
	public Task dequeue() {
        if (!isEmpty()) {
            Task tarefaRemovida = primeiroItem.tarefa;
            primeiroItem = primeiroItem.proximo;
            if (primeiroItem == null) {
                ultimoItem = null;
            }
            return tarefaRemovida;
        }
        return null;
    }

    public List<Task> toList() {
        List<Task> lista = new ArrayList<>();
        TaskNode aux = primeiroItem;
        while (aux != null) {
            lista.add(aux.tarefa);
            aux = aux.proximo;
        }
        return lista;
    }

}
