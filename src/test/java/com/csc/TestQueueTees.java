package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestQueueTees {

    private QueueTees queue;

    // Create a simple Cutie implementation for testing
    class TestCutie implements Cutie {
        private final String description;
        private final int cutenessRating;

        TestCutie(String description, int cutenessRating) {
            this.description = description;
            this.cutenessRating = cutenessRating;
        }

        @Override
        public String description() {
            return description;
        }

        @Override
        public Integer cutenessRating() {
            return cutenessRating;
        }
    }

    @BeforeEach
    void setUp() {
        queue = new QueueTees(3); // Queue with a capacity of 3
    }

    @Test
    void testEnqueueAndSize() {
        Cutie cutie = new TestCutie("A cute object!", 10);
        queue.enqueue(cutie);
        assertEquals(1, queue.size(), "Queue size should be 1 after enqueue.");
    }

    @Test
    void testDequeue() {
        Cutie cutie = new TestCutie("A cute object!", 10);
        queue.enqueue(cutie);
        assertEquals(cutie, queue.dequeue(), "Dequeue should return the first object.");
        assertEquals(0, queue.size(), "Queue size should be 0 after dequeuing.");
    }

    @Test
    void testOverflow() {
        Cutie cutie = new TestCutie("A cute object!", 10);
        queue.enqueue(cutie);
        queue.enqueue(cutie);
        queue.enqueue(cutie);
        queue.enqueue(cutie); // Should print "Queue is full!"

        assertEquals(3, queue.size(), "Queue size should remain at max capacity.");
    }

    @Test
    void testUnderflow() {
        assertNull(queue.dequeue(), "Dequeue from empty queue should return null.");
    }
}