import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class BankersAlgorithm {
    //np = no. of processes \ nr = no. of resources
    private int need[][],allocate[][],max[][],avail[][],noOfProcess,noOfResource;
    Random rand = new Random();

    private void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of processes and resources: ");
        noOfProcess=sc.nextInt();  //no. of processes
        noOfResource=sc.nextInt();  //no. of resources
        need=new int[noOfProcess][noOfResource];  //initializing arrays
        max=new int[noOfProcess][noOfResource];
        allocate=new int[noOfProcess][noOfResource];
        avail=new int[1][noOfResource];

        System.out.println("Allocation matrix: ");
        for(int i=0;i<noOfProcess;i++) {
            for (int j = 0; j < noOfResource; j++) {
                allocate[i][j] = (int) (Math.random() * 4 + 0);
                System.out.print(allocate[i][j]+"   ");
            }
            System.out.println();
        }

               // allocate[i][j]=sc.nextInt();  //allocation matrix

        System.out.println("Max. matrix: ");
        for(int i=0;i<noOfProcess;i++) {
            for (int j = 0; j < noOfResource; j++) {
                max[i][j] = (int) (Math.random() * 8 + 4);
                System.out.print(max[i][j] + "   ");
                //max[i][j]=sc.nextInt();  //max matrix
            }
            System.out.println();
        }

        System.out.println("Available matrix: ");
        for(int j=0;j<noOfResource;j++) {
            avail[0][j] = (int) (Math.random() * 5 + 0);
            System.out.println(avail[0][j]);
            // avail[0][j] = sc.nextInt();
            //available matrix
        }

        sc.close();
    }

    //calculate the need matrix
    private int[][] calc_need(){
        for(int i=0;i<noOfProcess;i++){
            for(int j=0;j<noOfResource;j++){  //calculating need matrix
                need[i][j]=max[i][j]-allocate[i][j];
            }
        }
        return need;
    }

    //Check if the requested resource is available or not
    private boolean check(int i){
        //checking if all resources for it^(h) process can be allocated
        for(int j=0;j<noOfResource;j++) {
            if(avail[0][j]<need[i][j]) {
                return false;
            }
        }
        return true;
    }


    // Check if by fulfilling the resource request the system remains in safe state
    public void isSafe(){
        input();
        calc_need();
        boolean done[]=new boolean[noOfProcess];
        int j=0;

        while(j<noOfProcess){  //loop until all process allocated
            boolean allocated=false;
            for(int i=0;i<noOfProcess;i++)
                if(!done[i] && check(i)){  //trying to allocate
                    for(int k=0;k<noOfResource;k++)
                        avail[0][k]=avail[0][k]-need[i][k]+max[i][k];
                    System.out.println("Allocated process : "+i);
                    allocated=done[i]=true;
                    j++;
                }
            if(!allocated) break;  //if no allocation
        }
        if(j==noOfProcess)  //if all processes are allocated
            System.out.println("\nSafely allocated!");
        else
            System.err.println("\nAll proceess can't be allocated safely!");
    }

    public static void main(String[] args) throws IOException {
        new BankersAlgorithm().isSafe();
    }
}