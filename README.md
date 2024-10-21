# CPU Scheduling Algorithms - Java Implementation

This project implements various CPU scheduling algorithms, commonly used in operating systems for managing process execution. It includes detailed implementations of the following algorithms:
- First-Come-First-Serve (FCFS)
- Priority Scheduling
- Round Robin (RR)
- Shortest Job First (SJF) (Preemptive and Non-Preemptive)

The project also contains utility classes to manage processes and interact with users.

## Table of Contents
1. [Overview](#overview)
2. [Algorithms Implemented](#algorithms-implemented)
    - [First-Come-First-Serve (FCFS)](#first-come-first-serve-fcfs)
    - [Priority Scheduling](#priority-scheduling)
    - [Round Robin (RR)](#round-robin-rr)
    - [Shortest Job First (SJF)](#shortest-job-first-sjf)
3. [Classes](#classes)
    - [Process](#process)
    - [ProcessList](#processlist)
    - [Utilities](#utilities)
    - [Driver](#driver)
4. [How to Run](#how-to-run)
5. [Example Output](#example-output)
6. [In-code pictures](#In-code pictures)

---

## Overview

This project simulates various CPU scheduling algorithms to help visualize and understand the different ways processes are handled in an operating system. Each algorithm has its own strengths and weaknesses, and this project provides a way to compare their performance through simulations.

---

## Algorithms Implemented

### First-Come-First-Serve (FCFS)

The **First-Come-First-Serve (FCFS)** algorithm schedules processes based on their arrival time. It is simple but can lead to long waiting times for shorter processes if a longer process is at the front.

### Priority Scheduling

**Priority Scheduling** is based on the priority level assigned to each process. The process with the highest priority is executed first. If two processes have the same priority, they are scheduled in the order they arrive.

### Round Robin (RR)

The **Round Robin (RR)** algorithm assigns a fixed time quantum to each process and cycles through the processes. It ensures fairness by allowing each process to have CPU time but may lead to context-switch overhead if the time quantum is too small.

### Shortest Job First (SJF)

The **Shortest Job First (SJF)** algorithm schedules the process with the shortest burst time first. It can be:
- **Preemptive**: The running process can be interrupted if a new process arrives with a shorter burst time.
- **Non-Preemptive**: Once a process starts, it runs to completion, regardless of new arrivals.

---

## Classes

### Process

The `Process` class is a representation of a process, containing attributes such as:
- **Process ID**
- **Burst Time**
- **Arrival Time**
- **Priority** (for priority-based scheduling)

It handles individual process properties for scheduling algorithms.

### ProcessList

The `ProcessList` class manages the list of processes and provides methods for sorting, scheduling, and retrieving processes based on different criteria (such as arrival time or burst time).

### Utilities

The `Utilities` class contains helper functions that make the implementation easier, such as random process generation or calculation of performance metrics like average waiting time.

### Driver

The `Driver` class is the main entry point of the project. It handles the interaction between the user and the scheduling algorithms, allowing the user to select the scheduling algorithm and view the results.

---

## How to Run

1. Download or clone the repository.
2. Compile the Java files using a Java compiler (`javac`).
3. Run the main `Driver.java` class to interact with the system and select the desired scheduling algorithm.

### Example Commands:

```bash
javac Driver.java
java Driver
```

## Example Output
```
Example output for the Round Robin (RR) algorithm with 4 processes and a time quantum of 4:
Enter number of processes: 4
Process 1: Burst Time = 10, Arrival Time = 0
Process 2: Burst Time = 5, Arrival Time = 2
Process 3: Burst Time = 8, Arrival Time = 3
Process 4: Burst Time = 4, Arrival Time = 5
Time Quantum = 4

Executing Round Robin Scheduling...
Process 1 executed for 4 units
Process 2 executed for 4 units
Process 3 executed for 4 units
Process 4 executed for 4 units ...

Average Waiting Time: 5.75 Average Turnaround Time: 11.5
```

##In-code pictures
