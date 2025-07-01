package com.br.kanban.estruturas;

import com.br.kanban.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilaPrioridadeTaskTest {

    private FilaPrioridadeTask fila;

    @BeforeEach
    void setUp() {
        fila = new FilaPrioridadeTask();
    }

    private TaskNode createTaskNode(String title, int priority) {
        Task task = new Task(title, "Descrição", priority, "Categoria", LocalDate.now().plusDays(5));
        return new TaskNode(task);
    }

    @Test
    void testEnqueueAndToList() {
        TaskNode t1 = createTaskNode("Alta", 3);
        TaskNode t2 = createTaskNode("Média", 2);
        TaskNode t3 = createTaskNode("Baixa", 1);
        TaskNode t4 = createTaskNode("Altíssima", 5);

        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);
        fila.enqueue(t4);

        List<Task> list = fila.toList();

        assertEquals(4, list.size());
        assertEquals("Altíssima", list.get(0).getTitle());
        assertEquals("Alta", list.get(1).getTitle());
        assertEquals("Média", list.get(2).getTitle());
        assertEquals("Baixa", list.get(3).getTitle());
    }

    @Test
    void testDequeue() {
        TaskNode t1 = createTaskNode("Task1", 4);
        TaskNode t2 = createTaskNode("Task2", 2);
        fila.enqueue(t1);
        fila.enqueue(t2);

        Task first = fila.dequeue();
        assertNotNull(first);
        assertEquals("Task1", first.getTitle());

        Task second = fila.dequeue();
        assertNotNull(second);
        assertEquals("Task2", second.getTitle());

        assertTrue(fila.isEmpty());
    }

    @Test
    void testIsEmptyInitially() {
        assertTrue(fila.isEmpty());
    }

    @Test
    void testIsEmptyAfterDequeueAll() {
        fila.enqueue(createTaskNode("Única", 1));
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    @Test
    void testDequeueFromEmptyQueueReturnsNull() {
        assertNull(fila.dequeue());
    }

}