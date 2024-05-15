import java.util.InputMismatchException;
import java.util.Scanner;
import Process.ProcessList;
import Process.Process;
import Scheduling_Algorithms.*;
import Styling.InteractionSystem;
import Styling.Utilities;

/**
 * Operating Systems - Project UQU 453
 * A project that aims to implement CPU scheduling algorithms:
 * First Come First Served, Shortest Job First, Shortest Job First
 * (non-preemptive), Shortest Job First (preemptive)
 * , Priority, and Round Robin.
 * 
 * @author Abdulaziz Hafiz, Ahmad Sindi, Ehab Yar, and Malek Allehaibi.
 * 
 *         Project --> <a href="https://github.com/C3ZIZ/OSProject.git"> Project
 *         on Github</a>
 */
public class Driver {
    public static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        ProcessList pList = new ProcessList();
        int processNum;
        Utilities.displayWithDelay("Welcome to CPU scheduler simulator\n", "white");

        int choice;
        while (true) {
            try {
                InteractionSystem.ProcessManageMenu();
                choice = scnr.nextInt();

                switch (choice) {
                    case 1:
                        Utilities.displayWithDelayNoLine("Enter the number of processes you want: ", "green");
                        processNum = scnr.nextInt();
                        if (processNum < 0) {
                            Utilities.displayWithDelay("Number of processes cannot be negative!", "red");
                            break;
                        }
                        for (int i = 1; i <= processNum; i++) {
                            pList.addProcess(InteractionSystem.ProcessManage());
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
                        Utilities.displayWithDelay("No Such Option!", "red");
                        break;
                }
            } catch (InputMismatchException e) {
                Utilities.displayWithDelay("Input must be a number!", "red");
                scnr.next();
            }
        }
    }
}