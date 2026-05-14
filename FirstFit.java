import java.util.*;

public class FirstFit {
    public static void main(String[] args) {
        int blocks[]={300,600,350,200,750,125};
        int processes[]={115,500,358,200,375};
        int arr[] = new int[processes.length];
        Arrays.fill(arr, -1);

        for (int i = 0; i < processes.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (blocks[j] >= processes[i]) {
                    arr[i] = j;
                    blocks[j] -= processes[i];
                    break;
                }
            }
        }

        System.out.println("Process No. | Process Size | Block No.");
        for (int i = 0; i < processes.length; i++) {
            System.out.print("    " + (i + 1) + "           " + processes[i] + "         ");
            if (arr[i] != -1) {
                System.out.println(arr[i] + 1);
            } else {
                System.out.println("Not Allocated");
            }
        }

        System.out.println("\nRemaining Free Space Blocks:");
        for (int i = 0; i < blocks.length; i++) {
            System.out.println("Block " + (i + 1) + " -> " + blocks[i]);
        }
    }
}
