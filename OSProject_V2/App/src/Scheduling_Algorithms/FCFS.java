package Scheduling_Algorithms;

import Process.ProcessList;
import Styling.Utilities;
import Process.Process;

/**
 * Represents the First-Come-First-Served (FCFS) scheduling algorithm.
 */
public class FCFS {

    /**
     * Calculates the waiting time, turnaround time, and average times for the
     * processes using the FCFS algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcFCFS(ProcessList pList, boolean withPriority) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAround = 0;
        int numOfProcess = pList.size();

        for (int i = 0; i < numOfProcess; i++) {
            Process process = toUseList.getProcess(i);
            process.setWaitingTime(currentTime);
            currentTime += process.getBurstTime();
            totalWaitingTime += process.getWaitingTime();
            process.setTurnAround(currentTime);
            totalTurnAround += process.getTurnAround();
        }
        if (withPriority) {
            toUseList.printList("priority");
        } else {
            toUseList.printList("fcfs");
        }
        toUseList.calcAvgTimes(totalWaitingTime, totalTurnAround, numOfProcess);
    }
}