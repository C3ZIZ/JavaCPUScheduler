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
6. [Contributing](#contributing)
7. [License](#license)

---

## Overview

This project simulates various CPU scheduling algorithms to help visualize and understand the different ways processes are handled in an operating system. Each algorithm has its own strengths and weaknesses, and this project provides a way to compare their performance through simulations.

---

## Algorithms Implemented

### First-Come-First-Serve (FCFS)

The **First-Come-First-Serve (FCFS)** algorithm schedules processes based on their arrival time. It is simple but can lead to long waiting times for shorter processes if a longer process is at the front.

- Source: `FCFS.java`

### Priority Scheduling

**Priority Scheduling** is based on the priority level assigned to each process. The process with the highest priority is executed first. If two processes have the same priority, they are scheduled in the order they arrive.

- Source: `Priority.java`

### Round Robin (RR)

The **Round Robin (RR)** algorithm assigns a fixed time quantum to each process and cycles through the processes. It ensures fairness by allowing each process to have CPU time but may lead to context-switch overhead if the time quantum is too small.

- Source: `RoundRobin.java`

### Shortest Job First (SJF)

The **Shortest Job First (SJF)** algorithm schedules the process with the shortest burst time first. It can be:
- **Preemptive**: The running process can be interrupted if a new process arrives with a shorter burst time.
- **Non-Preemptive**: Once a process starts, it runs to completion, regardless of new arrivals.

- Sources: `SJFPreemptive.java`, `SJFNonPreemptive.java`

---

## Classes

### Process

The `Process` class is a representation of a process, containing attributes such as:
- **Process ID**
- **Burst Time**
- **Arrival Time**
- **Priority** (for priority-based scheduling)

It handles individual process properties for scheduling algorithms.

- Source: `Process.java`

### ProcessList

The `ProcessList` class manages the list of processes and provides methods for sorting, scheduling, and retrieving processes based on different criteria (such as arrival time or burst time).

- Source: `ProcessList.java`

### Utilities

The `Utilities` class contains helper functions that make the implementation easier, such as random process generation or calculation of performance metrics like average waiting time.

- Source: `Utilities.java`

### Driver

The `Driver` class is the main entry point of the project. It handles the interaction between the user and the scheduling algorithms, allowing the user to select the scheduling algorithm and view the results.

- Source: `Driver.java`

---

## How to Run

1. Download or clone the repository.
2. Compile the Java files using a Java compiler (`javac`).
3. Run the main `Driver.java` class to interact with the system and select the desired scheduling algorithm.

### Example Commands:

```bash
javac Driver.java
java Driver
