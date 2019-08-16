package com.gerwyn.jones.data.structures.immutable.queue;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ImmutableQueueTest {

    @Test
    public void shouldReturnNewQueueWithAppendedEntry() {
        Queue<String> q1 = new ImmutableQueue<>();
        Queue<String> q2 = q1.enQueue("new entry 1");
        assertNotEquals(q1, q2);
        assertEquals(q2.head(), "new entry 1");
    }

    @Test
    public void shouldReturnNewQueueWithFirstEntryRemoved() {
        Queue<String> q1 = new ImmutableQueue<>();
        q1 = q1.enQueue("new entry 1");
        assertEquals(q1.head(), "new entry 1");
        q1 = q1.deQueue();
        assertEquals(q1.head(), null);
    }

    @Test
    public void shouldReturnNewANewEmptyQueueWhenDeQueueingAnEmptyQueue() {
        Queue<String> q1 = new ImmutableQueue<>();
        q1 = q1.enQueue("new entry 1");
        q1 = q1.enQueue("new entry 2");
        q1 = q1.deQueue();

        assertEquals("new entry 2", q1.head());
        Queue<String> result = q1.deQueue();

        assertNotEquals(q1, result);
        assertEquals(null, result.head());
    }

    @Test
    public void shouldReturnNullWhenHeadIsNotPresent() {
        Queue<String> q1 = new ImmutableQueue<>();
        assertEquals(q1.head(), null);
    }

    @Test
    public void shouldEvaluateWhetherQueueIsEmpty() {
        Queue<String> q1 = new ImmutableQueue<>();
        q1 = q1.enQueue("new entry 1");
        assertEquals(q1.isEmpty(), false);
        q1 = q1.deQueue();
        assertEquals(q1.isEmpty(), true);
    }
}
