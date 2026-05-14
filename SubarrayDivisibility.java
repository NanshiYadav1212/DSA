// import java.io.*;

// public class SubarrayDivisibility {
    // static int func(int n , int[] arr)
    // {
    //     int cnt=0;
    //     for(int i=0;i<n;i++)
    //     {
    //         long[] prefixSum=new long[n];
    //         prefixSum[i]=arr[i];
    //         if(prefixSum[i]%n==0)
    //         {
    //             cnt++;
    //         }
    //         if(i==n-1) break;
    //         for(int j=i+1;j<n;j++)
    //         {
    //             prefixSum[j]=prefixSum[j-1]+arr[j];
    //             if(prefixSum[j]%n==0)
    //             {
    //                 cnt++;
    //             }
    //         }
    //     }
    //     return cnt;
    // }

    // static int func(int n , int[] arr)
    // {
    //     int cnt=0;
    //     int[] prefixSum=new int[n];
    //     prefixSum[0]=arr[0];
    //     for(int i=1;i<n;i++)
    //     {
    //         prefixSum[i]=prefixSum[i-1]+arr[i];
    //     }
    //     for(int i=0;i<n;i++)
    //     {
    //         if(prefixSum[i]%n==0)
    //         {
    //             int temp=cnt;
    //             cnt += (temp + 1);
    //             //cnt++;
    //         }
    //     }

    //     return cnt;
    // }


//     static int func(int n,int[] arr)
//     {
//         int cnt=0;
//         long[] prefixSum=new long[n+1];
//         for(int i=0;i<n;i++)
//         {
//             prefixSum[i+1]=prefixSum[i]+arr[i];
//         }
//         Map<Long,Integer> mp=new HashMap<>();
//         for(int i=0;i<=n;i++)
//         {
//             long rem=((prefixSum[i]%n)+n)%n;
//             mp.put(rem,mp.getOrDefault(rem,0)+1);
//         }

//         for(long key:mp.keySet())
//         {
//             int k=mp.get(key);
//             cnt+=(k*(k-1))/2;
//         }
//         return cnt;
//     }
//     public static void main(String s[])
//     {
//          Scanner sc=new Scanner(System.in);
//          int n=sc.nextInt();
//          int[] arr=new int[n];
//          for(int i=0;i<n;i++)
//          {
//             arr[i]=sc.nextInt();
//          }
//          System.out.println(func(n,arr));
//     }
// }
import java.io.*;

public class SubarrayDivisibility {
    static class FastScanner{
        final InputStream in;
        final byte[] buffer=new byte[1 << 16];
        int ptr=0,len=0;
        FastScanner(InputStream is)
        {
            in=is;
        }
        int read() throws IOException{
            if(ptr>=len)
            {
                len=in.read(buffer);
                ptr=0;
                if(len<=0) 
                return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException
        {
            int c;
            while((c=read())<= ' ')
            {
                if(c==-1)
                return Integer.MIN_VALUE;
            }
            int sign=1;
            if(c=='-')
            {
                sign=-1;
                c=read();
            }
            int val=0;
            while(c>' ')
            {
                val=val*10 +(c-'0');
                c=read();
            }
            return val*sign;
        }
    }
        public static void main(String[] s) throws Exception{
            FastScanner fs=new FastScanner(System.in);
            int n=fs.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=fs.nextInt();
            }

            long[] freq=new long[n];
            long prefix=0;
            freq[0]=1;
            for(int i=0;i<n;i++)
            {
                prefix+=arr[i];
                int rem=(int)(((prefix%n)+n)%n);
                freq[rem]++;
            }

            long cnt=0L;
            for(long f:freq)
            {
                cnt+= f*(f-1)/2;
            }
            System.out.println(cnt);
        }
    
}



// q2
public class SubarrayDivisibility { 
            public static void main(String[] s) throws Exception{
            FastScanner fs=new FastScanner(System.in);
            int n=fs.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=fs.nextInt();
            }

            long[] freq=new long[n];
            long prefix=0;
            freq[0]=1;
            for(int i=0;i<n;i++)
            {
                prefix+=arr[i];
                int rem=(int)(((prefix%n)+n)%n);
                freq[rem]++;
            }

            long cnt=0L;
            for(long f:freq)
            {
                cnt+= f*(f-1)/2;
            }
            System.out.println(cnt);
        }
}
//Tc :o(n) , sc : o(n)