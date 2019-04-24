import java.util.Random;

class FFit {

    static Random rand = new Random();

    static void firstFit(int blockSize[], int m, int processSize[], int n) {
        int allocation[] = new int[n];
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    break;
                }
            }
        }

        System.out.println("\nProcess No.  \tProcess Size  \tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i+1) + "\t\t       "+ processSize[i] + " \t\t       ");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int blockSize[] = new int[6];
        int processSize[] = new int[6];
        for(int i = 0; i < blockSize.length; i++)
            blockSize[i] = rand.nextInt(50);
        for(int i = 0; i < processSize.length; i++)
            processSize[i] = rand.nextInt(100);
        int m = blockSize.length;
        int n = processSize.length;

        firstFit(blockSize, m, processSize, n);
    }
} 