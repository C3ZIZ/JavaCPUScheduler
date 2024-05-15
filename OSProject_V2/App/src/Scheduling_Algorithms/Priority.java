package Scheduling_Algorithms;

import Process.ProcessList;
import Styling.Utilities;

/**
 * Represents the Priority scheduling algorithm.
 * Extends the FCFS class. (Priority is the same as FCFS but with an ordered requsts)
 */
public class Priority extends FCFS {

    /**
     * Calculates the waiting time, turnaround time, and average times for the processes using the Priority scheduling algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcPriority(ProcessList pList) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        toUseList.sortByPriority();
        FCFS.calcFCFS(toUseList, true);
    }
}