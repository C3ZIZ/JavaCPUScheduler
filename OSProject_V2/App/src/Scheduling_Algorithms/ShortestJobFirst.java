package Scheduling_Algorithms;

import Process.ProcessList;

/**
 * Represents the Shortest Job First (SJF) scheduling algorithm.
 * Extends the FCFS class. (SJF with no arrival time is the same as FCFS 
 * where we give the process full time to execute but diffrent in that SJF is sorted)
 */
public class ShortestJobFirst extends FCFS {

    /**
     * Calculates the waiting time, turnaround time, and average times for the processes using the SJF scheduling algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcSJF(ProcessList pList) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        toUseList.sortByBurstTime();
        FCFS.calcFCFS(toUseList);
    }
}