package Styling;
import java.util.InputMismatchException;
import java.util.Scanner;
import Process.ProcessList;
import Process.Process;
import Scheduling_Algorithms.*;
import Styling.Utilities;

public class InteractionSystem {
    public static Scanner scnr = new Scanner(System.in);

    public static void AlgorithmMenu() {
        Utilities.displayWithDelay("Choose your algorithm:", "white");
        Utilities.displayWithDelay("1: Show menu\n", "white");
        Utilities.displayWithDelay("2: First Come First Served (FCFS)\n3: Shortest Job First (SJF)", "white");
        Utilities.displayWithDelay("4: SJF (non-preemptive)\n5: SJF (preemptive)", "white");
        Utilities.displayWithDelay("6: Priority\n7: Round Robin (RR)\n8: Exit", "white");
        Utilities.displayWithDelayNoLine("Your input >> ", "green");
    }
    public static void ProcessManageMenu(){
        Utilities.displayWithDelay("Create your Processes:", "white");
        Utilities.displayWithDelay("1: Add process\n", "white");
        Utilities.displayWithDelay("2: Display Processes\n", "white");
        Utilities.displayWithDelay("3: Choose Algorithm\n", "white");
    }
    public static Process ProcessManage(){
        Utilities.displayWithDelay("Enter Process BurstTime: \n", "white");
            int burstTime = scnr.nextInt();
        Utilities.displayWithDelay("Enter Process Priority (enter 0 if there isn't): \n", "white");
            int priority = scnr.nextInt();
            return (new Process(burstTime,priority));

    }

    public static void chooseAlgorithm(int choise, ProcessList pList){
        while (true) {

            try {

                choise = scnr.nextInt();

                switch (choise) {
                    case 1:
                        AlgorithmMenu();
                        break;
                    case 2:
                        Utilities.displayWithDelay("FCFS will execute...\n", "white");
                        FCFS.calcFCFS(pList);
                        break;
                    case 3:
                        Utilities.displayWithDelay("SJF will execute...\n", "white");
                        ShortestJobFirst.calcSJF(pList);
                        break;
                    case 4:
                        Utilities.displayWithDelay("SJF(non-preemptive) will execute...\n", "white");
                        SJFNonPreemptive.calcSJFNonPreemptive(pList);
                        break;
                    case 5:
                        Utilities.displayWithDelay("SJF(preemptive) will execute...\n", "white");
                        SJFPreemptive.calcSRTF(pList);
                        break;
                    case 6:
                        Utilities.displayWithDelay("Priority will execute...\n", "white");
                        Priority.calcPriority(pList);
                        break;
                    case 7:
                        Utilities.displayWithDelay("Round Robin will execute...\n", "white");
                        Utilities.displayWithDelay("Enter your quantum value\n", "white");
                        int quantum = scnr.nextInt();
                        RoundRobin.calcRR(pList, quantum);
                        break;
                    case 8:
                           System.exit(0);
                        break;
                    default:
                        break;
                }

            } catch (InputMismatchException e) {
                Utilities.displayWithDelay("Choise must be a number!", "red");
                scnr.next();
            }
}
    }
}
