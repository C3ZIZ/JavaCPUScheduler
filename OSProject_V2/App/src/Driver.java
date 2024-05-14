import java.util.InputMismatchException;
import java.util.Scanner;
import Process.ProcessList;
import Process.Process;
import Scheduling_Algorithms.*;
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
        pList.addProcess(new Process(11, 2));
        pList.addProcess(new Process(5, 1));


        Priority.calcPriority(pList);
    }

}
