import java.util.*;

class MissingNumber{
    static int missingNumber(int n,int[] arr){
         long total=((long)n*(n+1))/2;
         long sum=0;
         for(int i=0;i<arr.length;i++){
              sum+=arr[i];
         }
         return (int)(total-sum);
    }

    // static int missingNumber(int n,int[] arr)
    // {
    //     long total=((n)*(n+1))/2;
    //     for(int i=0;i<arr.length;i++)
    //     {
    //         total-=arr[i];
    //     }
    //     return (int)total;
    // }
   public static void main(String[] s) {
       {
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int[] arr=new int[n-1];
           //System.out.println("Enter the elements of array");
           for(int i=0;i<n-1;i++)
           {
             arr[i]=sc.nextInt();
           }
           int ans= missingNumber(n,arr);
           System.out.println(ans);
       }
   }
}