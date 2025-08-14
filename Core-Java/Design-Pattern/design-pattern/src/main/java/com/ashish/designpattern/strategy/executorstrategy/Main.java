package com.ashish.designpattern.strategy.executorstrategy;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


// Executor is the strategy interface defining the execute() method.
// Executors class provides factory methods to create different types of executors with different execution strategies.
// newSingleThreadExecutor() creates an executor that uses a single worker thread.
// newFixedThreadPool(int nThreads) creates an executor with a fixed number of worker threads.
// newCachedThreadPool() creates an executor that creates new threads as needed but reuses existing ones if they are available.
// This example demonstrates how the Strategy pattern is used in the Java API to provide different execution strategies for running tasks asynchronously. Depending on the context or requirements, you can choose the appropriate executor strategy without modifying the task execution logic.
public class Main {
    public static void main(String[] args) {
        // Create a task
        Runnable task = () -> {
            System.out.println("Task is executed by " + Thread.currentThread().getName());
        };

        // Create different executors with different execution strategies

        // Strategy 1: Single-threaded executor
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(task);

        // Strategy 2: Fixed thread pool executor
        Executor fixedThreadPoolExecutor = Executors.newFixedThreadPool(2);
        fixedThreadPoolExecutor.execute(task);

        // Strategy 3: Cached thread pool executor
        Executor cachedThreadPoolExecutor = Executors.newCachedThreadPool();
        cachedThreadPoolExecutor.execute(task);
    }
}

