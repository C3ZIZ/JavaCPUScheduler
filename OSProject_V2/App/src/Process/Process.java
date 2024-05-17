package Process;

/**
 * Represents a process in a scheduling algorithm.
 */
public class Process {

    /**
     * instance variables section, cotains the most importnant attributes of a process.
     */
    private String processName;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int waitingTime;
    private int turnAround;
    private int remainTime;
    private int minTurnAround;
    private int maxWaiting;
    private boolean cut;
    private static int processID = 1;


    /**
     * Constructs a process with burst time, and priority.
     *
     * @param burstTime   The burst time required for the process.
     */
    public Process(int burstTime, int arrivalTime) {
        this.processName = "P" + processID;
        this.burstTime = burstTime;
        this.priority = 0;
        this.arrivalTime = arrivalTime;
        waitingTime = 0;
        turnAround = 0;
        remainTime = burstTime;
        minTurnAround = 0;
        maxWaiting = 0;
        cut = false;
        processID++;
    }

    /**
     * Constructs a process with burst time, and priority.
     *
     * @param burstTime   The burst time required for the process.
     * @param priority    The priority of the process.
     */
    public Process(int burstTime, int arrivalTime, int priority) {
        this.processName = "P" + processID;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        waitingTime = 0;
        turnAround = 0;
        remainTime = burstTime;
        minTurnAround = 0;
        maxWaiting = 0;
        cut = false;
        processID++;
    }

    /**
     * Retrieves the name of the process.
     *
     * @return The name of the process.
     */
    public String getProcessName() {
        return this.processName;
    }

    /**
     * Sets the name of the process.
     *
     * @param processName The name of the process.
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * Retrieves the arrival time of the process.
     *
     * @return The arrival time of the process.
     */
    public int getArrivalTime() {
        return this.arrivalTime;
    }

    /**
     * Sets the arrival time of the process.
     *
     * @param arrivalTime The arrival time of the process.
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Retrieves the burst time of the process.
     *
     * @return The burst time of the process.
     */
    public int getBurstTime() {
        return this.burstTime;
    }

    /**
     * Sets the burst time of the process.
     *
     * @param burstTime The burst time of the process.
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * Retrieves the priority of the process.
     *
     * @return The priority of the process.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Sets the priority of the process.
     *
     * @param priority The priority of the process.
     */
    public void setPriority(int priority) {
        this.priority= priority;
    }

    /**
     * Retrieves the waiting time of the process.
     *
     * @return The waiting time of the process.
     */
    public int getWaitingTime() {
        return this.waitingTime;
    }

    /**
     * Sets the waiting time of the process.
     *
     * @param waitingTime The waiting time of the process.
     */
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * Retrieves the turnaround time of the process.
     *
     * @return The turnaround time of the process.
     */
    public int getTurnAround() {
        return this.turnAround;
    }

    /**
     * Sets the turnaround time of the process.
     *
     * @param turnAround The turnaround time of the process.
     */
    public void setTurnAround(int turnAround) {
        this.turnAround = turnAround;
    }

    /**
     * Retrieves the remaining time of the process.
     *
     * @return The remaining time of the process.
     */
    public int getRemainTime() {
        return this.remainTime;
    }

    /**
     * Sets the remaining time of the process.
     *
     * @param remainTime The remaining time of the process.
     */
    public void setRemainTime(int remainTime) {
        this.remainTime = remainTime;
    }

    /**
     * Retrieves the cut status of the process.
     *
     * @return The cut status of the process.
     */
    public boolean getCut() {
        return this.cut;
    }

    /**
     * Sets the cut status of the process.
     *
     * @param cut The cut status of the process.
     */
    public void setCut(boolean cut) {
        this.cut = cut;
    }

    /**
     * Retrieves the minimum turnAround time of the process.
     *
     * @return The minimum turnAround time of the process.
     */
    public int getMinTurnAround() {
        return this.minTurnAround;
    }

    /**
     * Sets the minimum turnAround time of the process.
     *
     * @param minTurnAround The minimum turnAround time of the process.
     */
    public void setMinTurnAround(int minTurnAround) {
        this.minTurnAround = minTurnAround;
    }

    /**
     * Retrieves the maximum waiting time of the process.
     *
     * @return The maximum waiting time of the process.
     */
    public int getMaxWaiting() {
        return this.maxWaiting;
    }

    /**
     * Sets the maximum waiting time of the process.
     *
     * @param maxWaiting The maximum waiting time of the process.
     */
    public void setMaxWaiting(int maxWaiting) {
        this.maxWaiting = maxWaiting;
    }

    /**
     * Decreases the remaining time of the process by 1.
     */
    public void decreaseRemainingTime() {
        this.remainTime--;
    }
} // End of Process class...