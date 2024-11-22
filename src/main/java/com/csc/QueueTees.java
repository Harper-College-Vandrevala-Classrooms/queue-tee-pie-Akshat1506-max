package com.csc;

public class QueueTees {
    private Cutie[] queue; // Array to store Cutie objects
    private int front;     // Index for the front of the queue
    private int rear;      // Index for the rear of the queue
    private int size;      // Current size of the queue
    private int capacity;  // Maximum capacity of the queue

    // Constructor
    public QueueTees(int capacity) {
        this.capacity = capacity;
        this.queue = new Cutie[capacity]; // Initialize the array
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue method to add a Cutie object
    public void enqueue(Cutie cutie) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot add more cuties.");
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = cutie;
        size++;
        System.out.println("Added: " + cutie.description());
    }

    // Dequeue method to remove and return the front Cutie object
    public Cutie dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        }
        Cutie dequeued = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Removed: " + dequeued.description());
        return dequeued;
    }

    // Method to return the current size of the queue
    public int size() {
        return size;
    }
}