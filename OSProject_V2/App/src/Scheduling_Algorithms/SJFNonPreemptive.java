package Scheduling_Algorithms;

import Process.Process;
import Process.ProcessList;

/**
 * Represents the Shortest Job First (SJF) Non-Preemptive scheduling algorithm.
 */
public class SJFNonPreemptive {

    /**
     * Calculates the waiting time, turnaround time, and average times for the processes using the SJF Non-Preemptive scheduling algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcSJFNonPreemptive(ProcessList pList) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        toUseList.sortByBurstTime();
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAround = 0;
        int numOfProcess = toUseList.size();

        for (int i = 0; i < numOfProcess; i++) {
            Process process = toUseList.getProcess(i);
            process.setWaitingTime(currentTime - process.getArrivalTime());
            currentTime += process.getBurstTime();
            totalWaitingTime += process.getWaitingTime();
            process.setTurnAround(currentTime - process.getArrivalTime());
            totalTurnAround += process.getTurnAround();
        }
        toUseList.printList();
        toUseList.calcAvgTimes(totalWaitingTime, totalTurnAround, numOfProcess);
    }
}