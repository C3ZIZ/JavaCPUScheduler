package Styling;

import java.util.InputMismatchException;
import java.util.Scanner;
import Process.ProcessList;
import Process.Process;
import Scheduling_Algorithms.*;
import Styling.Utilities;

public class InteractionSystem {
    public static Scanner scnr = new Scanner(System.in);

    public static void initialize() {
        ProcessList pList = new ProcessList();
        int processNum;
        Utilities.displayWithDelay("Welcome to CPU scheduler simulator\n", "white");
        int choice;
        char usePriority;
        while (true) {
            try {
                InteractionSystem.ProcessManageMenu();
                choice = scnr.nextInt();

                switch (choice) {
                    case 1:
                        Utilities.displayWithDelayNoLine("Enter the number of processes you want: ", "green");
                        processNum = scnr.nextInt();
                        if (processNum <= 0) {
                            Utilities.displayWithDelay("Number of processes must be positive!", "red");
                            break;
                        }
                        Utilities.displayWithDelayNoLine("Do you want to use priority? (Y/N) >> ", "green");
                        usePriority = scnr.next().charAt(0);
                        usePriority = Character.toLowerCase(usePriority);
                        if (usePriority != 'y' && usePriority != 'n') {
                            Utilities.displayWithDelay("Invalid choice!", "red");
                            break;
                        } else if (usePriority == 'y') {
                            for (int i = 1; i <= processNum; i++) {
                                pList.addProcess(InteractionSystem.ProcessManage(true));
                            }
                        } else {
                            for (int i = 1; i <= processNum; i++) {
                                pList.addProcess(InteractionSystem.ProcessManage(false));
                            }
                        }
                        break;
                    case 2:
                        if (pList.isEmpty()) {
                            Utilities.displayWithDelay("Process list is empty!", "red");
                        } else {
                            pList.printList("show-content");
                        }
                        break;
                    case 3:
                        InteractionSystem.AlgorithmMenu();
                        int choose = scnr.nextInt();
                        InteractionSystem.chooseAlgorithm(choose, pList);
                        break;
                    case 4:
                        Utilities.displayWithDelay("Exiting the program...", "white");
                        System.exit(0);
                        break;
                    default:
                        Utilities.displayWithDelay("Invalid choise!", "red");
                        break;
                }
            } catch (InputMismatchException e) {
                Utilities.displayWithDelay("Input must be a number!\n", "red");
                scnr.next();
            }
        }
    }

    public static void AlgorithmMenu() {
        Utilities.displayWithDelay("Choose your algorithm:", "white");
        Utilities.displayWithDelay("1: Show menu", "white");
        Utilities.displayWithDelay("2: First Come First Served (FCFS)\n3: Shortest Job First (SJF)", "white");
        Utilities.displayWithDelay("4: SJF (non-preemptive)\n5: SJF (preemptive)", "white");
        Utilities.displayWithDelay("6: Priority\n7: Round Robin (RR)\n8: Exit", "white");
        Utilities.displayWithDelayNoLine("Your input >> ", "green");
    }

    public static void ProcessManageMenu() {
        Utilities.displayWithDelay("What operation you want:", "white");
        Utilities.displayWithDelay("1: Add process", "white");
        Utilities.displayWithDelay("2: Display Processes", "white");
        Utilities.displayWithDelay("3: Choose Algorithm", "white");
        Utilities.displayWithDelay("4: Exit", "white");
        Utilities.displayWithDelayNoLine("Your input >> ", "green");
    }

    public static Process ProcessManage(boolean usePriority) {
        boolean isValidInput = false;
        Process process = null;

        if (usePriority) {
            while (!isValidInput) {
                try {
                    Utilities.displayWithDelayNoLine("Enter Process's BurstTime >> ", "white");
                    int burstTime = scnr.nextInt();
                    if (burstTime <= 0) {
                        throw new IllegalArgumentException("Burst time must be positive!");
                    }

                    Utilities.displayWithDelayNoLine("Enter Process's ArrivalTime >> ", "white");
                    int arrivalTime = scnr.nextInt();
                    if (arrivalTime <= 0) {
                        throw new IllegalArgumentException("Arrival time must be positive!");
                    }

                    Utilities.displayWithDelayNoLine("Enter Process's Priority >> ", "white");
                    int priority = scnr.nextInt();
                    if (priority <= 0) {
                        throw new IllegalArgumentException("Priority must be positive!");
                    }

                    Utilities.displayWithDelay("-----------------------------------------------", "white");
                    process = new Process(burstTime, arrivalTime, priority);
                    isValidInput = true;
                } catch (InputMismatchException e) {
                    Utilities.displayWithDelay("Input must be a number!", "red");
                    scnr.next(); // Clear the incorrect input
                } catch (IllegalArgumentException e) {
                    Utilities.displayWithDelay(e.getMessage(), "red");
                }
            }
        } else {
            while (!isValidInput) {
                try {
                    Utilities.displayWithDelayNoLine("Enter Process's BurstTime >> ", "white");
                    int burstTime = scnr.nextInt();
                    if (burstTime <= 0) {
                        throw new IllegalArgumentException("Burst time must be positive!");
                    }

                    Utilities.displayWithDelayNoLine("Enter Process's ArrivalTime >> ", "white");
                    int arrivalTime = scnr.nextInt();
                    if (arrivalTime <= 0) {
                        throw new IllegalArgumentException("Arrival time must be positive!");
                    }

                    Utilities.displayWithDelay("-----------------------------------------------", "white");
                    process = new Process(burstTime, arrivalTime);
                    isValidInput = true;
                } catch (InputMismatchException e) {
                    Utilities.displayWithDelay("Input must be a number!", "red");
                    scnr.next(); // Clear the incorrect input
                } catch (IllegalArgumentException e) {
                    Utilities.displayWithDelay(e.getMessage(), "red");
                }
            }
        }

        while (!isValidInput) {
            try {
                Utilities.displayWithDelayNoLine("Enter Process's BurstTime >> ", "white");
                int burstTime = scnr.nextInt();
                if (burstTime < 0) {
                    throw new IllegalArgumentException("Burst time cannot be negative!");
                }

                Utilities.displayWithDelayNoLine("Enter Process's Priority (Enter 0 for no priority) >> ", "white");
                int priority = scnr.nextInt();
                if (priority < 0) {
                    throw new IllegalArgumentException("Priority cannot be negative!");
                }

                Utilities.displayWithDelay("-----------------------------------------------", "white");
                process = new Process(burstTime, priority);
                isValidInput = true;
            } catch (InputMismatchException e) {
                Utilities.displayWithDelay("Input must be a number!", "red");
                scnr.next(); // Clear the incorrect input
            } catch (IllegalArgumentException e) {
                Utilities.displayWithDelay(e.getMessage(), "red");
            }
        }

        return process;
    }

    public static void chooseAlgorithm(int choice, ProcessList pList) {
        try {
            switch (choice) {
                case 1:
                    AlgorithmMenu();
                    break;
                case 2:
                    Utilities.displayWithDelay("FCFS will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        FCFS.calcFCFS(pList, false);
                    }
                    break;
                case 3:
                    Utilities.displayWithDelay("SJF will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        ShortestJobFirst.calcSJF(pList);
                    }
                    break;
                case 4:
                    Utilities.displayWithDelay("SJF (non-preemptive) will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        SJFNonPreemptive.calcSJFNonPreemptive(pList);
                    }
                    break;
                case 5:
                    Utilities.displayWithDelay("SJF (preemptive) will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        SJFPreemptive.calcSRTF(pList);
                    }
                    break;
                case 6:
                    Utilities.displayWithDelay("Priority will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        Priority.calcPriority(pList);
                    }
                    break;
                case 7:
                    Utilities.displayWithDelay("Round Robin will execute...\n", "white");
                    if (pList.isEmpty()) {
                        Utilities.displayWithDelay("Error: Process list is empty!", "red");
                    } else {
                        Utilities.displayWithDelay("Enter your quantum value: ", "white");
                        int quantum = scnr.nextInt();
                        RoundRobin.calcRR(pList, quantum);
                    }
                    break;
                case 8:
                    Utilities.displayWithDelay("Exiting the program...", "white");
                    System.exit(0);
                    break;
                default:
                    Utilities.displayWithDelay("Invalid choice!", "red");
                    break;
            }
        } catch (InputMismatchException e) {
            Utilities.displayWithDelay("Choice must be a number!", "red");
            scnr.next();
        }
    }
}