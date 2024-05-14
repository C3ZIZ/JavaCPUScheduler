package Scheduling_Algorithms;

import Process.Process;
import Process.ProcessList;
import Styling.Utilities;

/**
 * The RoundRobin class implements the Round Robin scheduling algorithm.
 */
public class RoundRobin {

    /**
     * Calculates the waiting time, turn around time, and average times of processes using the Round Robin algorithm.
     *
     * @param pList   The list of processes to schedule.
     * @param quantum The time quantum for each process.
     */
    public static void calcRR(ProcessList pList, int quantum) {
        ProcessList toUseList = new ProcessList(pList.size());
        toUseList.addAll(pList);
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int numOfProcess = pList.size();
        int clock = 0;
        boolean finish = false;
        
        // it will be easier to check the processes by order in a (while true loop) until all process remaining time is zero.
        do {
            finish = true;

            // Checks if all processes are finished (remain time is zero).
            for (int i = 0; i < numOfProcess; i++) {
                Process process = toUseList.getProcess(i);
                if (process.getRemainTime() > 0) {
                    finish = false;
                    break;
                }
            }

            // check a process condtion (current remain time)
            for (int i = 0; i < numOfProcess; i++) {
                Process process = toUseList.getProcess(i);
                if (process.getRemainTime() != 0) {
                    if (process.getRemainTime() > quantum) {
                        clock += quantum;   // I use clock to know that we have passed a stage.
                        process.setRemainTime(process.getRemainTime() - quantum);
                    } else {
                        clock += process.getRemainTime();
                        process.setWaitingTime(clock - process.getBurstTime());
                        process.setRemainTime(0);

                        // Calculate turn around time
                        process.setTurnAround(process.getBurstTime() + process.getWaitingTime());

                        // Calculate total waiting and turn around time
                        totalWaitingTime += process.getWaitingTime();
                        totalTurnAroundTime += process.getTurnAround();
                    }
                }
            }
        } while (!finish);

        // Print the process list and calculate average times
        System.out.println();
        toUseList.printList();
        toUseList.calcAvgTimes(totalWaitingTime, totalTurnAroundTime, numOfProcess);
        Utilities.displayWithDelay("Total number of switches: "+numOfSwitches(pList, quantum), "magenta");
    }

    /**
     * A method that find the total number of switches.
     * By: Abdulziz and Ahmad ^_~
     * @param pList
     * @param quantum
     * @return Number of process swtiches for given round robin process list
     */
    private static int numOfSwitches(ProcessList pList, int quantum){
        double totalBurstTime = 0;
        double temp = 0 ;
        for ( int i = 0 ; i < pList.size() ; i++ ) {
            temp = (double)pList.getProcess(i).getBurstTime() / (double)quantum;
            temp = Math.ceil(temp);
            totalBurstTime += temp;
        }
        return ((int)totalBurstTime - 1);
    }
}