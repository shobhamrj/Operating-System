import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

class FCFS {

    static Random rand = new Random();
    static Scanner scan = new Scanner(System.in);

    // Function to find the waiting time for all  
    // processes  
    static void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
        // waiting time for first process is 0  
        wt[0] = 0;

        // calculating waiting time  
        for (int i = 1; i < n; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
    }

    // Function to calculate turn around time  
    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        // calculating turnaround time by adding  
        // bt[i] + wt[i]  
        for (int i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
        }
    }

    //Function to calculate average time  
    static void findAvgTime(int processes[], int noOfProcess, int brustTime[]) {
        int waitingTime[] = new int[noOfProcess], turnAroundTime[] = new int[noOfProcess];
        int totalWaitingTime = 0, totalTurnAroundTime = 0;

        //Function to find waiting time of all processes  
        findWaitingTime(processes, noOfProcess, brustTime, waitingTime);

        //Function to find turn around time for all processes  
        findTurnAroundTime(processes, noOfProcess, brustTime, waitingTime, turnAroundTime);

        //Display processes along with all details  
        System.out.printf("Processes Burst time Waiting time Turn around time\n");

        // Calculate total waiting time and total turn  
        // around time  
        for (int i = 0; i < noOfProcess; i++) {
            totalWaitingTime = totalWaitingTime + waitingTime[i];
            totalTurnAroundTime = totalTurnAroundTime + turnAroundTime[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("       %d ", brustTime[i]);
            System.out.printf("       %d", waitingTime[i]);
            System.out.printf("       %d\n", turnAroundTime[i]);
        }
        float s = (float)totalWaitingTime /(float) noOfProcess;
        int t = totalTurnAroundTime / noOfProcess;
        System.out.printf("Average waiting time = %f", s);
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }


    public static void main(String[] args) throws ParseException {

        int processes[] = new int[5];
        for(int i = 0; i < processes.length; i++) {
            processes[i] = rand.nextInt(10);
        }
        int noOfProcess = processes.length;

        //Burst time of all processes  
        int burstTime[] = new int[5];
        for(int i = 0; i < burstTime.length; i++) {
            burstTime[i] = rand.nextInt(50);
        }

        findAvgTime(processes, noOfProcess, burstTime);

    }
} 