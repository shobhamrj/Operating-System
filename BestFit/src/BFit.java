import java.util.Random;

public class BFit {
    static Random rand = new Random();

    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        int allocation[] = new int[n];
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;
        for (int i = 0; i < processSize.length; i++) {
            int bestIdx = -1;
            for (int j=0; j < blockSize.length; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }

            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                blockSize[bestIdx] -= processSize[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i+1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print("      "+allocation[i] + 1);
            else
                System.out.print("      Not Allocated");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int blockSize[] = new int [6];
        int processSize[] = new int[6];
        for(int i = 0; i < blockSize.length; i++)
            blockSize[i] = rand.nextInt(50);
        for(int i = 0; i < processSize.length; i++)
            processSize[i] = rand.nextInt(100);
        int m = blockSize.length;
        int n = processSize.length;

        bestFit(blockSize, m, processSize, n);
    }
}