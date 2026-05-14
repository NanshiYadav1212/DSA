import java.util.*;

class MaximumEvenSum{
    static int func(int a,int b)
    {
        int maxSum=-1;
        for(int i=1;i<b+1;i++)
        {
            if(b%i ==0)
            {
                if((a*i)%2==0  && (b%i)%2==0)
                { 
                    // even - even
                    maxSum=Math.max(maxSum,(a*i + b%i));
                }
                else if((a*i)%2!=0  && (b%i)%2!=0)
                {
                    // odd - odd
                    maxSum=Math.max(maxSum,(a*i + b%i));
                }
                else {
                    continue;
                }
            }
        }
        return maxSum;
    }
    public static void main(String s[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][2];
        int[][] ans=new int[n][1];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
            ans[i][0]=func(arr[i][0],arr[i][1]);
        }

        for(int i=0;i<n;i++)
        {
            System.out.println(ans[i][0]);
        }
    }

}