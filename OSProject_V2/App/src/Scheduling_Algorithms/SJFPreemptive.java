package Scheduling_Algorithms;

import Process.Process;
import Process.ProcessList;

/**
 * Represents the Shortest Job First (SJF) Preemptive scheduling algorithm.
 */
public class SJFPreemptive {

    /**
     * Calculates the waiting time, turnaround time, and average times for the processes using the SJF Preemptive scheduling algorithm.
     *
     * @param pList The list of processes to be scheduled.
     */
    public static void calcSRTF(ProcessList pList) {
        // Define variables
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);

        // The clock of the program
        int clock = 0;
        // Total processes
        int processes = pList.size();
        // Total completed processes
        int completedProcesses = 0;
        // Total waiting time
        double totalWaitingTime = 0.0;
        // Total turnaround time
        double totalTurnaroundTime = 0.0;
        // Get the last process that has been served
        Process lastServedProcess = toUseList.getFirst();

        // Stop when all processes are completed
        while (completedProcesses < processes) {

            // Get the shortest remaining time process at this time (depends on the clock)
            Process shortestRemainingTimeProcess = toUseList.getShortestRemainingTimeProcess(clock);

            // If the CPU-served process is changed
            if (!lastServedProcess.getProcessName().equals(shortestRemainingTimeProcess.getProcessName())) {
                // If the last process served isn't completed yet, put a flag on it that it has been cut
                if (lastServedProcess.getRemainTime() != 0)
                    lastServedProcess.setCut(true);
                // Set the minimum turnaround time as the clock when the process is cut
                lastServedProcess.setMinTurnAround(clock);
                // Replace the lastServedProcess with the current process (shortest remaining time process)
                lastServedProcess = shortestRemainingTimeProcess;
                // Set the max waiting time for the current process as the clock when it starts or resumes
                lastServedProcess.setMaxWaiting(clock);
            }
            // Decrease the remaining time of the current process by 1
            lastServedProcess.decreaseRemainingTime();
            // Increase the clock
            clock++;
            // If the current process is completed
            if (lastServedProcess.getRemainTime() == 0) {
                // Increase the completed processes counter
                completedProcesses++;
                // Calculate the waiting time for the completed process
                int waitingTime = lastServedProcess.getCut()
                        ? lastServedProcess.getMaxWaiting() - lastServedProcess.getMinTurnAround()
                        : lastServedProcess.getMaxWaiting() - lastServedProcess.getArrivalTime();
                // Update the waiting time for the completed process
                lastServedProcess.setWaitingTime(waitingTime);
                // Update the total waiting time
                totalWaitingTime += waitingTime;
                // Calculate the turnaround time for the completed process
                int turnaroundTime = clock - lastServedProcess.getArrivalTime();
                // Update the turnaround time for the completed process
                lastServedProcess.setTurnAround(turnaroundTime);
                // Update the total turnaround time
                totalTurnaroundTime += turnaroundTime;
            }
        }
        // Print the process list and average times
        toUseList.printList();
        toUseList.calcAvgTimes((int) totalWaitingTime, (int) totalTurnaroundTime, processes);
    }
}