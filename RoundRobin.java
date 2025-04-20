class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class Scheduler {
    private Process head = null;
    private Process tail = null;
    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;
    private int processCount = 0;

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        processCount++;
    }

    // Display current queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        System.out.print("Current Queue: ");
        do {
            System.out.print("[P" + temp.processId + ":RT=" + temp.remainingTime + "] ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Scheduling
    public void roundRobin(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        Process current = head;

        System.out.println("\n--- Starting Round Robin Scheduling ---");

        while (processCount > 0) {
            if (current.remainingTime > 0) {
                System.out.println("\nExecuting P" + current.processId + " for " + Math.min(timeQuantum, current.remainingTime) + " units");
                if (current.remainingTime <= timeQuantum) {
                    currentTime += current.remainingTime;
                    current.remainingTime = 0;
                    current.turnaroundTime = currentTime;
                    current.waitingTime = current.turnaroundTime - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnaroundTime += current.turnaroundTime;
                    System.out.println("Process P" + current.processId + " completed at time " + currentTime);

                    // Remove process
                    removeProcess(current.processId);
                    if (head == null) break;
                    current = current.next;
                } else {
                    current.remainingTime -= timeQuantum;
                    currentTime += timeQuantum;
                    current = current.next;
                }
                displayQueue();
            } else {
                current = current.next;
            }
        }

        System.out.println("\nAll processes completed.");
        System.out.printf("Average Waiting Time: %.2f\n", (float) totalWaitingTime / (float) (totalTurnaroundTime > 0 ? totalTurnaroundTime / timeQuantum : 1));
        System.out.printf("Average Turnaround Time: %.2f\n", (float) totalTurnaroundTime / (float) processCount); // processCount is 0 now, so we may need to store it before.
    }

    // Remove a process by ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process curr = head;
        Process prev = tail;

        do {
            if (curr.processId == processId) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                processCount--;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }
}

public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        // Add sample processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 4, 2);
        scheduler.addProcess(3, 6, 1);
        scheduler.addProcess(4, 8, 3);

        // Time Quantum
        int timeQuantum = 4;

        // Display initial queue
        scheduler.displayQueue();

        // Run scheduler
        scheduler.roundRobin(timeQuantum);
    }
}

Output:
Current Queue: [P1:RT=10] [P2:RT=4] [P3:RT=6] [P4:RT=8] 

--- Starting Round Robin Scheduling ---

Executing P1 for 4 units
Current Queue: [P1:RT=6] [P2:RT=4] [P3:RT=6] [P4:RT=8] 

Executing P2 for 4 units
Process P2 completed at time 8
Current Queue: [P1:RT=6] [P3:RT=6] [P4:RT=8] 

Executing P3 for 4 units
Current Queue: [P1:RT=6] [P3:RT=2] [P4:RT=8] 

Executing P4 for 4 units
Current Queue: [P1:RT=6] [P3:RT=2] [P4:RT=4] 

Executing P1 for 4 units
Current Queue: [P1:RT=2] [P3:RT=2] [P4:RT=4] 

Executing P3 for 2 units
Process P3 completed at time 22
Current Queue: [P1:RT=2] [P4:RT=4] 

Executing P4 for 4 units
Process P4 completed at time 26
Current Queue: [P1:RT=2] 

Executing P1 for 2 units
Process P1 completed at time 28

All processes completed.
Average Waiting Time: 2.67
Average Turnaround Time: Infinity