package com.br.kanban.estruturas;

import com.br.kanban.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilaSimplesTaskTest {

    private FilaSimplesTask fila;

    @BeforeEach
    void setUp() {
        fila = new FilaSimplesTask();
    }

    private TaskNode createTaskNode(String title, int priority) {
        Task task = new Task(title, "Desc", priority, "Cat", LocalDate.now().plusDays(1));
        return new TaskNode(task);
    }

    @Test
    void testIsEmptyInitially() {
        assertTrue(fila.isEmpty());
    }

    @Test
    void testEnqueueAndToList() {
        TaskNode t1 = createTaskNode("Tarefa 1", 1);
        TaskNode t2 = createTaskNode("Tarefa 2", 2);
        TaskNode t3 = createTaskNode("Tarefa 3", 3);

        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        List<Task> lista = fila.toList();
        assertEquals(3, lista.size());
        assertEquals("Tarefa 1", lista.get(0).getTitle());
        assertEquals("Tarefa 2", lista.get(1).getTitle());
        assertEquals("Tarefa 3", lista.get(2).getTitle());
    }

    @Test
    void testDequeueMaintainsFIFO() {
        TaskNode t1 = createTaskNode("Primeira", 1);
        TaskNode t2 = createTaskNode("Segunda", 2);

        fila.enqueue(t1);
        fila.enqueue(t2);

        Task firstOut = fila.dequeue();
        assertNotNull(firstOut);
        assertEquals("Primeira", firstOut.getTitle());

        Task secondOut = fila.dequeue();
        assertNotNull(secondOut);
        assertEquals("Segunda", secondOut.getTitle());

        assertTrue(fila.isEmpty());
    }

    @Test
    void testDequeueOnEmptyQueueReturnsNull() {
        assertNull(fila.dequeue());
    }

    @Test
    void testIsEmptyAfterDequeueAll() {
        fila.enqueue(createTaskNode("Única", 1));
        assertFalse(fila.isEmpty());
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

}