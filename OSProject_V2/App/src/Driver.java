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
 *         Project --> <a href=
 *         "https://github.com/C3ZIZ/OSProject.git"> Project on Github</a>
 */
public class Driver {
    public static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {
        ProcessList pList = new ProcessList();
        int ProcessNum;
        Utilities.displayWithDelay("Welcome to CPU scheduler simulator\n", "white");

        InteractionSystem.ProcessManageMenu();
        int choice; 
        while (true) {
            choice = scnr.nextInt();

            switch (choice) {
                case 1:
                    Utilities.displayWithDelayNoLine("Enter the number of Process you want >> ", "green");
                    ProcessNum = scnr.nextInt();
                    for(int i = 1 ; i <= ProcessNum ; i++){
                    pList.addProcess(InteractionSystem.ProcessManage());
                    }
                    InteractionSystem.ProcessManageMenu();
                    break;
                case 2:
                    pList.printList("show-content");
                    InteractionSystem.ProcessManageMenu();
                    break;
                case 3:
                InteractionSystem.AlgorithmMenu();
                    int choose = scnr.nextInt();
                    InteractionSystem.chooseAlgorithm(choose,pList);
                    break;
                default:
                    break;
            }
        }
    }

}
