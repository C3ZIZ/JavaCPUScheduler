package Process;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Styling.Utilities;

/**
 * Represents a list of processes in a scheduling algorithm.
 */
public class ProcessList {

    private ArrayList<Process> pList;

    /**
     * Constructs an empty process list.
     */
    public ProcessList() {
        pList = new ArrayList<Process>();
    }

    /**
     * Constructs a process list with the specified initial capacity.
     *
     * @param numOfProcess The initial capacity of the process list.
     */
    public ProcessList(int numOfProcess) {
        pList = new ArrayList<Process>(numOfProcess);
    }

    /**
     * Adds a process to the process list,
     * and sets auto arrival time.
     * 
     * @param p The process to be added.
     */
    public void addProcess(Process p) {
        pList.add(p);
        pList.get(pList.size() - 1).setArrivalTime(size() - 1);
    }


    /**
     * Removes a process from the list
     * @param process to remoev
     */
    public void removeProcess(Process process) {
        pList.remove(process);
    }

    /**
     * Retrieves the process at the specified index in the process list.
     *
     * @param index The index of the process to retrieve.
     * @return The process at the specified index.
     */
    public Process getProcess(int index) {
        return pList.get(index);
    }

    /**
     * Retrieves the first process in the process list.
     *
     * @return The first process in the process list.
     */
    public Process getFirst() {
        return pList.get(0);
    }

    /**
     * Retrieves the size of the process list.
     *
     * @return The size of the process list.
     */
    public int size() {
        return pList.size();
    }

    /**
     * Sorts the process list by burst time in ascending order.
     */
    public void sortByBurstTime() {
        /*
         * Using collection sort (source, operation (here we use comparator taking the
         * type
         * of class and traverse each process's burt time) )
         */
        Collections.sort(pList, Comparator.comparingInt(Process::getBurstTime));
    }

    /**
     * Sorts the process list by priority in ascending order.
     */
    public void sortByPriority() {
        // Same as sortByBurstTime method but comapring priority (;
        Collections.sort(pList, Comparator.comparingInt(Process::getPriority));
    }

    /**
     * Sorts the process list by arrival time in ascending order.
     */
    public void sortByArrivalTime() {
        // Same as sortByBurstTime method but comapring priority (;
        Collections.sort(pList, Comparator.comparingInt(Process::getArrivalTime));
    }

    /**
     * Adds all processes from another process list to this process list.
     *
     * @param otherList The process list to be added.
     */
    public void addAll(ProcessList otherList) {
        for (Process p : otherList.pList) {
            pList.add(p);
        }
    }

    public boolean isEmpty() {
        return pList.isEmpty();
    }

    /**
     * Retrieves the process with the shortest remaining time at a given arrival
     * time.
     *
     * @param arrivalTime The arrival time to consider.
     * @return The process with the shortest remaining time at the given arrival
     *         time.
     */
    public Process getShortestRemainingTimeProcess(int arrivalTime) {
        Process shortest = null;
        for (int i = 0; i < size(); i++) {
            if (pList.get(i).getRemainTime() == 0)
                continue;
            if (shortest == null) {
                shortest = pList.get(i);
                continue;
            }
            if (shortest.getRemainTime() > pList.get(i).getRemainTime()
                    && arrivalTime >= pList.get(i).getArrivalTime()) {
                shortest = pList.get(i);
            }
        }
        return shortest;
    }

    /**
     * Prints the process list with the process details.
     */
    public void printList(String algorithmType) {
        sortByArrivalTime();
        String processList = "";
        algorithmType = algorithmType.toLowerCase();
        if (algorithmType.equals("fcfs") || algorithmType.equals("sjf") || algorithmType.equals("rr")) {
            processList += "ProcessName\tBurstTime\tWaitingTime\tTurnAroundTime\n";
            for (int i = 0; i < pList.size(); i++) {
                processList += pList.get(i).getProcessName() + "\t\t";
                processList += pList.get(i).getBurstTime() + "\t\t";
                processList += pList.get(i).getWaitingTime() + "\t\t";
                processList += pList.get(i).getTurnAround() + "\t\t";
                processList += "\n";
            }

        } else if (algorithmType.equals("sjf-non-preemptive") || algorithmType.equals("sjf-preemptive")) {
            processList += "ProcessName\tBurstTime\tArrivalTime\tWaitingTime\tTurnAroundTime\n";
            for (int i = 0; i < pList.size(); i++) {
                processList += pList.get(i).getProcessName() + "\t\t";
                processList += pList.get(i).getBurstTime() + "\t\t";
                processList += pList.get(i).getArrivalTime() + "\t\t";
                processList += pList.get(i).getWaitingTime() + "\t\t";
                processList += pList.get(i).getTurnAround() + "\t\t";
                processList += "\n";
            }
        } else if (algorithmType.equals("priority")) {
            processList += "ProcessName\tBurstTime\tPriority\tWaitingTime\tTurnAroundTime\n";
            for (int i = 0; i < pList.size(); i++) {
                processList += pList.get(i).getProcessName() + "\t\t";
                processList += pList.get(i).getBurstTime() + "\t\t";
                processList += pList.get(i).getPriority() + "\t\t";
                processList += pList.get(i).getWaitingTime() + "\t\t";
                processList += pList.get(i).getTurnAround() + "\t\t";
                processList += "\n";
            }
        } else if (algorithmType.equals("show-content")) {
            processList += "ProcessName\tBurstTime\n";
            for (int i = 0; i < pList.size(); i++) {
                processList += pList.get(i).getProcessName() + "\t\t";
                processList += pList.get(i).getBurstTime() + "\t\t";
                processList += "\n";
            }
        } else {
            Utilities.displayWithDelay("No such algorithm!", "red");
        }

        Utilities.displayWithDelay(processList, "white");
    }

    /**
     * Calculates the average waiting time and average turnaround time.
     *
     * @param totalWaitingTime The total waiting time of all processes.
     * @param totalTurnAround  The total turnaround time of all processes.
     * @param numOfProcess     The number of processes.
     */
    public void calcAvgTimes(int totalWaitingTime, int totalTurnAround, int numOfProcess) {
        double avgWaitingTime = (double) totalWaitingTime / numOfProcess;
        double avgTurnAround = (double) totalTurnAround / numOfProcess;

        Utilities.displayWithDelay("Average Waiting Time: " + avgWaitingTime, "magenta");
        Utilities.displayWithDelay("Average Turnaround Time: " + avgTurnAround, "magenta");
    }

} // End of ProcessList class...