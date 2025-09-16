/*import java.util.*;
public class SubarraySums1 {
    static int func(int n,int x, int[] arr)
    {
    //     int ans=0;
    //    // int sum=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         int sum=0;
    //         for(int j=i;j<n;j++)
    //         {
    //              sum+=arr[j];
    //              if(sum==x){
    //                 ans++;
    //              }
    //              else if(sum>x)
    //              {
    //                 break;
    //              }
    //         }
    //     }
    //     return ans;
    Map<Integer, Integer> freq = new HashMap<>();
    freq.put(0,1); // prefix sum zero occurs once
    int prefix = 0, ans = 0;

    for (int num : arr) 
    {
            prefix += num;
            if (freq.containsKey(prefix-x)) 
            {
                ans+=freq.get(prefix-x);
            }
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }
        return ans;

    }
    public static void main(String s[])
    {
       // Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        //int x=sc.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++ ){
            arr[i]=sc.nextInt();
        }
        int ans=func(n,x,arr);
        System.out.println(ans);
    }
}
*/

import java.util.*;

public class SubarraySums1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long count = 0;
        int left=0;
        long sum=0;
        for (int right=0;right<n;right++) {
            sum+=arr[right];
            while (sum>x && left<=right) 
            {
                sum -= arr[left++];
            }

            if (sum == x) 
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
