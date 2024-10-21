# CPU Scheduling Algorithms - Java Implementation

This project implements various CPU scheduling algorithms, commonly used in operating systems for managing process execution. It includes detailed implementations of the following algorithms:
- First-Come-First-Serve (FCFS)
- Priority Scheduling
- Round Robin (RR)
- Shortest Job First (SJF) (Preemptive and Non-Preemptive)

The project also contains utility classes to manage processes and interact with users, made for CS2342 [Course info at UQU](https://uqu.edu.sa/App/Degrees/740/34694).

Author: Abdulaziz Hafiz, CS student at UQU, [LinkedIn](https://www.linkedin.com/in/c3ziz/).

## Table of Contents
1. [Overview](#overview)
2. [Key Features](#key-features)
3. [Algorithms Implemented](#algorithms-implemented)
    - [First-Come-First-Serve (FCFS)](#first-come-first-serve-fcfs)
    - [Priority Scheduling](#priority-scheduling)
    - [Round Robin (RR)](#round-robin-rr)
    - [Shortest Job First (SJF)](#shortest-job-first-sjf)
4. [Classes](#classes)
    - [Process](#process)
    - [ProcessList](#processlist)
    - [Utilities](#utilities)
    - [InteractionSystem](#InteractionSystem)
    - [Driver](#driver)
5. [How to Run](#how-to-run)
6. [Example Output](#example-output)
7. [In-code pictures](#In-code-pictures)
8. [Troubleshooting](#troubleshooting)
9. [Advanced Usage](#advanced-usage)

---

## Overview

This project simulates various CPU scheduling algorithms to help visualize and understand the different ways processes are handled in an operating system. Each algorithm has its own strengths and weaknesses, and this project provides a way to compare their performance through simulations.

---

## Key Features

- Multiple Scheduling Algorithms: Implements FCFS, Priority Scheduling, Round Robin, and both Preemptive and Non-Preemptive Shortest Job First (SJF) algorithms.
- User Interaction System: Interactive menus for easy selection of algorithms and input handling.
- Process Management: Comprehensive ProcessList class to manage and schedule multiple processes.
- Utility Functions: Includes helper functions for enhanced user interface, such as colored terminal outputs.

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

The `Utilities` class contains helper functions that make the code more elegant such as terminal coloring with simple animation.

### InteractionSystem

The `InteractionSystem` class serves as the core interactive component of a CPU scheduler simulator containing the initialization, menus, algorithms invoking, and error handling.

### Driver

The `Driver` class is the main entry point of the project. It handles the interaction between the user and the scheduling algorithms.

---

## How to Run

1. Download or clone the repository.
2. Compile the Java files using a Java compiler (`javac`).
3. Run the main `Driver.java` class to interact with the system and select the desired scheduling algorithm.

---

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
---

## In-code-Pictures

Screenshots showing various parts of the program:

1. **Main Menu:**
   _Main menu interface where users can select the scheduling algorithm._

   ![Main Menu](https://github.com/C3ZIZ/JavaCPUScheduler/blob/18257e978481b82f28e9b73288fd8589030641db/Pictures/c1.png)
   
   

2. **Process List Overview:**
   _Display of processes and their attributes (ID, burst time, arrival time, priority) before scheduling._

   ![Process List Overview](https://github.com/C3ZIZ/JavaCPUScheduler/blob/18257e978481b82f28e9b73288fd8589030641db/Pictures/c2.png)
   

3. **Scheduling Example (FCFS):**
    _Example of First-Come-First-Serve (FCFS) scheduling algorithm in action._
   
   ![Scheduling Example (FCFS)](https://github.com/C3ZIZ/JavaCPUScheduler/blob/18257e978481b82f28e9b73288fd8589030641db/Pictures/c3.png)
   

---

## Troubleshooting

Common problems with solutions

- Code not running:
-- Cause: an error in IDE (especially in VSCode).
-- Solution: make sure you have [Java extension pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) for VSCode installed.

- Scheduling results not displayed
-- Cause: Process list may be empty or incorrectly initialized.
-- Solution: Ensure that the processes are added to the list before running any scheduling algorithm by using option 2 (display processes).

- Infinite loop during process execution
-- Cause: Scheduling algorithm never terminates due to improper handling of process completion or incorrect exit conditions.
-- Solution: Ensure that processes are being properly marked as "completed" once their burst time reaches zero. Ensure the Burst and arrival times are non-negative while adding processes.

---

## Advanced Usage

You can create scripts to define and run multiple scheduling algorithms in sequence and add them manually.

```java
// Script to automate scheduling tasks

public class Script {
    public static void main(String[] args) {
        // Create process list
        ProcessList processList = new ProcessList();
        processList.addProcess(new Process(1, 5, 0, 2));
        processList.addProcess(new Process(2, 10, 1, 1));

        // Run FCFS
        FCFS fcfs = new FCFS(processList);
        fcfs.execute();
        
        // Run Round Robin
        RoundRobin rr = new RoundRobin(processList, 4);
        rr.execute();
    }
}
```
### Integrations
| Application | Description                                             | Link                                |
|------------------|---------------------------------------------------------|-------------------------------------|
| **CPU-Scheduling**       | Basic site scheduler on Github by Aryan Darji. | [Github]([https://grafana.com](https://github.com/Aryan-Darji-07/CPU-Scheduling)      |
| **Process Scheduling Solver**    | Open-source online scheduler providing vairous algorithms showing most relevant info for each process. | [boonsuen]([https://prometheus.io](https://process-scheduling-solver.boonsuen.com/) |
| **Hirusha Cooray Scheduler**       | Simple open-source scheduler by Hirusha Cooray. | [Hirusha Cooray](https://www.jenkins.io)   |
