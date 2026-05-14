// euclidean method 
class Solution {
public int GCD(int a, int b) {
    if (b == 0)
        return Math.abs(a);  // In case of negative input
    return GCD(b, a % b);
}
}

// itereative 
// public int GCD(int a, int b) {
//     while (b != 0) {
//         int temp = b;
//         b = a % b;
//         a = temp;
//     }
//     return Math.abs(a);
// }



//-----------------------------------


// class Solution {
//     public boolean isArmstrong(int n) {
//         int original = n;
//         int digits = String.valueOf(n).length(); // Count of digits
//         int sum = 0;

//         while (n!= 0) {
//             int digit = n% 10;
//             sum += Math.pow(digit, digits);
//             n/= 10;
//         }
//         return sum==original;
//     }
// }


//-------------------------

/* You are given an integer n. You need to find all the divisors of n. Return all 
the divisors of n as an array or list in a sorted order.



A number which completely divides another number is called it's divisor.
Examples:
Input: n = 6

Output = [1, 2, 3, 6]

Explanation: The divisors of 6 are 1, 2, 3, 6.
---------------

import java.util.*;

class Solution {
    public List<Integer> getDivisors(int n) {
        Set<Integer> divisors = new HashSet<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }

        List<Integer> result = new ArrayList<>(divisors);
        Collections.sort(result);
        return result;
    }
}


*/


//---------------------------- RECURSIVE -> SUM OF 1ST N NATURAL NO.
/*
class Solution {
    // Recursive function to calculate the sum of first n natural numbers
    int sum(int i, int n) {
        if (i > n) {
            return 0;
        }
        return i + sum(i + 1, n); // add current number and recurse
    }

    public int NnumbersSum(int N) {
        return sum(1, N);
    }
}

*/
