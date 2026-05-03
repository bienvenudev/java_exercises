## Overview

This set of exercises is designed to help you understand **concurrency in Java** through building small, realistic command-line systems.

you will build programs that require:

* background work
* multiple tasks running at the same time
* coordination between tasks
* safe handling of shared data

## Learning Goals

By completing these exercises, you should be able to:

### Core Understanding

* Explain what a thread is and why it is used
* Run tasks in the background without blocking the main program
* Understand that execution order is **not guaranteed**
* Create and start threads
* Run multiple tasks concurrently
* Control execution flow (waiting, delaying, stopping)
* Understand problems caused by shared data
* Recognize inconsistent or incorrect results due to concurrency
* Fix those issues without removing concurrency
* Separate **tasks** from **workers**
* Limit how many things run at the same time

## Why Do We Simulate Delays?

In real systems, tasks take time:

* processing an order
* handling a request
* encoding a video
* writing to a database

If everything runs instantly, you **cannot observe concurrency problems**.

So we simulate time delays to:
* force overlap between tasks
* make concurrency visible
* create realistic behavior

## How to Simulate Delays in Java

The simplest way to simulate a delay is using:

```java
Thread.sleep(milliseconds);
```

### Example:

```java
try {
    System.out.println("Processing...");
    Thread.sleep(2000); // 2 seconds
    System.out.println("Done!");
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

### Important Notes

* `Thread.sleep` pauses **only the current thread**
* Other threads can continue running
* You must handle `InterruptedException`


## Common Challenges You Will Face

### 1. Program Freezing

If your program becomes unresponsive:

* your work is likely running on the main thread

### 2. Output Is Mixed or Out of Order

This is expected:
* multiple threads print at the same time


### 3. Incorrect Results

You might see:

* wrong counts
* missing updates
* duplicated results

This happens when:
* multiple threads modify shared data



### 5. Too Many Things Running at Once

Creating too many threads can:
* slow down your program
* make behavior unpredictable


## General Hints (Across All Exercises)

### Think About “Who Is Doing the Work”

* Is the main thread doing everything?
* Or are you delegating work somewhere else?


### Separate “Task” from “Execution”

* A task = what needs to be done
* Execution = who runs it


### Don’t Assume Order

Never rely on:
* which task runs first
* when it finishes

### Be Careful with Shared Data

If multiple threads:

* read AND write the same variable

You might get incorrect results.


### Keep the System Responsive
* keep accepting input
* do not block the main thread

