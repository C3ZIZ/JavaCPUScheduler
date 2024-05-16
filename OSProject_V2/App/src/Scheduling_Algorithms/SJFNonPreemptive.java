package Scheduling_Algorithms;

import Process.Process;
import Process.ProcessList;

/**
 * Represents the Shortest Job First (SJF) Non-Preemptive scheduling algorithm.
 */
public class SJFNonPreemptive {

    /**
     * Calculates the waiting time, turnaround time, and average times for the
     * processes using the SJF Non-Preemptive scheduling algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcSJFNonPreemptive(ProcessList pList) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        toUseList.sortByArrivalTime(); // Sort by arrival time

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int numOfProcesses = toUseList.size();
        int completedProcesses = 0;

        while (completedProcesses < numOfProcesses) {
            Process shortestJob = null;
            int shortestBurstTime = Integer.MAX_VALUE;

            for (int i = 0; i < toUseList.size(); i++) {
                Process ServeProcess = toUseList.getProcess(i);

                if (ServeProcess.getArrivalTime() <= currentTime &&
                        ServeProcess.getRemainTime() < shortestBurstTime && ServeProcess.getRemainTime() > 0) {
                    shortestJob = ServeProcess;
                    shortestBurstTime = ServeProcess.getRemainTime();
                }
            }

            // Work on shortest current process
            if (shortestJob != null) {
                shortestJob.setWaitingTime(currentTime - shortestJob.getArrivalTime());
                currentTime += shortestJob.getRemainTime();
                shortestJob.setTurnAround(currentTime - shortestJob.getArrivalTime());

                totalWaitingTime += shortestJob.getWaitingTime();
                totalTurnAroundTime += shortestJob.getTurnAround();

                shortestJob.setRemainTime(0);
                completedProcesses++;
            } else {
                currentTime++; // If no process is available, move to the next time unit
            }
        }

        pList.printList("sjf-non-preemptive");
        pList.calcAvgTimes(totalWaitingTime, totalTurnAroundTime, numOfProcesses);
    }
}