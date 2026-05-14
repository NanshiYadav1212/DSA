// public class PetersonAlgorithm {
//     static boolean[] flag = new boolean[2];
//     static int turn;
//     public static void main(String[] args){
//         int i=0;
//         int j=1-i;
//         flag[i]=true;
//         turn=j;
//         while (flag[j] && turn == j){}
//         System.out.println("i " + i + " in critical region");
//         flag[i] = false;
//     }
// }

public class PetersonAlgorithm
{    static boolean[] flag = new boolean[2];
    static int turn;
    public static void main(String[] args) {
        Thread p0 = new Thread(()->critical(0));
        Thread p1 = new Thread(()->critical(1));
        p0.start();
        p1.start();
    }
    public static void critical(int i) 
    {
        int j=1-i;
        for (int k = 0; k < 5; k++) 
        {
            flag[i] = true;
            turn = j;
            while (flag[j] && turn == j) 
            {
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