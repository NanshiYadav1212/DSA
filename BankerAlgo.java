import java.util.Scanner;
public class BankerAlgo {
    int numberOfProcesses;
    int numberOfResources;
    int[][] max;
    int[][] allocation;
    int[][] need;
    int[] available;
    int[] safeSequence;

public BankerAlgo(int numberOfProcesses, int numberOfResources) 
    {
        this.numberOfProcesses = numberOfProcesses;
        this.numberOfResources = numberOfResources;
        this.max = new int[numberOfProcesses][numberOfResources];
        this.allocation = new int[numberOfProcesses][numberOfResources];
        this.need = new int[numberOfProcesses][numberOfResources];
        this.available = new int[numberOfResources];
        this.safeSequence = new int[numberOfProcesses];
    }

public void initializeMatrices(Scanner scanner) 
    {
        System.out.println("Enter the Max matrix:");
        for (int i = 0; i < numberOfProcesses; i++) 
        {
            for (int j = 0; j < numberOfResources; j++) {
                max[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the Allocation matrix:");
        for (int i = 0; i < numberOfProcesses; i++) {
            for (int j = 0; j < numberOfResources; j++) {
                allocation[i][j] = scanner.nextInt();
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }
        System.out.println("Enter the Available resources:");
        for (int i = 0; i < numberOfResources; i++) {
            available[i] = scanner.nextInt();
        }
    }

public boolean isSafeState() 
    {
        boolean[] finish = new boolean[numberOfProcesses];
        int[] work = available.clone();
        int count = 0;
        while (count < numberOfProcesses) 
        {
            boolean found=false;
            for (int i=0;i<numberOfProcesses;i++) {
                if (!finish[i] && canProcessExecute(i, work)) {
                    for (int j = 0; j<numberOfResources;j++) {
                        work[j]+=allocation[i][j];
                    }
                    safeSequence[count++] = i;
                    finish[i] = true;
                    found = true;
                }
            }

            if(!found) 
            {
                return false; 
            }
        }
        return true;
    }

boolean canProcessExecute(int process, int[] work) 
     {
        for (int j=0;j<numberOfResources;j++) 
        {
            if (need[process][j]>work[j]) 
            {
                return false;
            }
        }
        return true;
    }

public boolean requestResources(int process, int[] request) 
    {
        for (int i = 0; i < numberOfResources; i++) 
        {
            if (request[i] > need[process][i]) 
            {
                System.out.println("Error: Process has exceeded maximum claim.");
                return false;
            }
            if (request[i] > available[i]) 
            {
                System.out.println("Resources not available. Process must wait.");
                return false;
            }
        }
        for (int i=0;i<numberOfResources;i++) 
        {
            available[i]-=request[i];
            allocation[process][i] += request[i];
            need[process][i]-=request[i];
        }
        if (isSafeState()) 
        {
            System.out.println("Request granted. System remains in a safe state.");
            return true;
        } 
        else 
        {
            for (int i = 0; i < numberOfResources; i++) 
            {
                available[i] += request[i];
                allocation[process][i] -= request[i];
                need[process][i] += request[i];
            }
            System.out.println("Request denied. System would be in an unsafe state.");
            return false;
        }
    }

public void displaySafeSequence() 
    {
        if (isSafeState()) {
            System.out.print("Safe sequence is: ");
            for (int i = 0;i<numberOfProcesses;i++) {
                System.out.print("P" + safeSequence[i] + " ");
            }
            System.out.println();
        } 
        else 
        {
            System.out.println("No safe sequence found. System is in an unsafe state.");
        }
    }

public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int pr=sc.nextInt();
        System.out.print("Enter number of resources: ");
        int rs=sc.nextInt();
        BankerAlgo ba=new BankerAlgo(pr, rs);
        ba.initializeMatrices(sc);
        ba.displaySafeSequence();
        System.out.print("Enter the process number to request resources: ");
        int p=sc.nextInt();
        int[] r=new int[rs];
        System.out.print("Enter the resource request: ");
        for (int i=0;i<rs;i++) 
        {
            r[i] = sc.nextInt();
        }
        ba.requestResources(p,r);
        sc.close();
    }
}



public class PetersonAlgorithm {
    static boolean[] flag = new boolean[2];
    static int turn;
    public static void main(String[] args) {
        Thread p0 = new Thread(() -> criticalSection(0));
        Thread p1 = new Thread(() -> criticalSection(1));
        p0.start();
        p1.start();
    }

    public static void criticalSection(int i) {
        int j=1-i;
        for (int k = 0; k < 5; k++) 
        {
            flag[i] = true;
            turn = j;
            while (flag[j] && turn == j) {
            }
            try 
            {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
            flag[i] = false;
            System.out.println("Process " + i + " exited critical section.\n");
            try 
            {
                Thread.sleep(500);
            } 
            catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }
    }
}