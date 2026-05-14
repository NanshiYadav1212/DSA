/*
class Solution {
    static void linearSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k = 5;
        linearSearch(arr, k);
    }
}
*/


// 2. binary search
// import java.util.*;
// class Solution{
//     static void binarySearch(int[] arr, int target)
//     {
//         int low=0;
//         int high=arr.length-1;
//         while(low<=high)
//         {
//             int mid=low +(high-low)/2;
//             if(arr[mid]==target)
//             {
//                 System.out.println(" found element at "+ mid);
//                 return;
//                         }
//             if(arr[mid]<target)
//             {
//                 low=mid+1;            
//             }
//             else {
//                 high=mid-1;
//             }
//         }
         
//         if(low>high)
//         {
//             System.out.println("Element not found ");
//         }
        

//     }
//     public static void main(String s[])
//     {
//         Scanner sc=new Scanner(System.in);
//         System.out.println("give the array size");
//         int n=sc.nextInt();
//         int arr[]=new int[n];
//         System.out.println("give the array elements");  

//         for(int i=0;i<n;i++)
//         {
//             arr[i]=sc.nextInt();
//         }
         
//         int target=sc.nextInt();
//         binarySearch(arr,target);
//     }
// }



//3. sort

import java.util.*;

class Result {

    /*
     * Helper class to manage interval data and sorting logic.
     */
    static class Interval implements Comparable<Interval> {
        long start;
        long end;
        String brand;

        public Interval(long start, long end, String brand) {
            this.start = start;
            this.end = end;
            this.brand = brand;
        }

        @Override
        public int compareTo(Interval other) {
            // Sort primarily by start time ascending
            if (this.start != other.start) {
                return Long.compare(this.start, other.start);
            }
            // If starts are equal, put the longer interval first. 
            // This ensures containers are processed before their subsets.
            return Long.compare(other.end, this.end);
        }
    }

    /*
     * Complete the 'obfuscateCardMetadata' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER card_bin
     * 2. STRING_ARRAY card_intervals
     */

    public static List<String> obfuscateCardMetadata(int card_bin, List<String> card_intervals) {
        List<Interval> intervals = new ArrayList<>();

        // 1. Parse Input
        for (String line : card_intervals) {
            String[] parts = line.split(",");
            long start = Long.parseLong(parts[0].trim());
            long end = Long.parseLong(parts[1].trim());
            String brand = parts[2].trim();
            intervals.add(new Interval(start, end, brand));
        }

        // 2. Sort intervals
        Collections.sort(intervals);

        // 3. Separate Roots (Covering intervals) from Subsets
        List<Interval> roots = new ArrayList<>();
        List<Interval> subsets = new ArrayList<>();
        
        long maxEnd = -1;
        
        for (Interval iv : intervals) {
            // If the interval ends within the current maxEnd, it is a subset.
            // (Since we sorted by start, iv.start is guaranteed to be >= current start)
            if (iv.end <= maxEnd) {
                subsets.add(iv);
            } else {
                // This is a top-level interval (either disjoint or extending the range)
                roots.add(iv);
                maxEnd = iv.end;
            }
        }

        // 4. Part 2: Gap Filling (Only on Roots)
        // Iterate through roots and extend to fill gaps
        for (int i = 0; i < roots.size() - 1; i++) {
            Interval current = roots.get(i);
            Interval next = roots.get(i + 1);
            
            // If there is a gap (next start is > current end + 1)
            if (current.end < next.start - 1) {
                current.end = next.start - 1;
            }
        }

        // 5. Part 4: Merging Adjacent Intervals (On both lists separately)
        List<Interval> mergedRoots = mergeIntervals(roots);
        List<Interval> mergedSubsets = mergeIntervals(subsets);

        // 6. Combine and Format Output
        List<Interval> finalIntervals = new ArrayList<>();
        finalIntervals.addAll(mergedRoots);
        finalIntervals.addAll(mergedSubsets);
        
        // Final sort to ensure output order is correct
        Collections.sort(finalIntervals);

        List<String> output = new ArrayList<>();
        String binStr = String.valueOf(card_bin);
        
        for (Interval iv : finalIntervals) {
            // Format numbers to 10 digits with leading zeros
            String startStr = String.format("%010d", iv.start);
            String endStr = String.format("%010d", iv.end);
            
            // Construct the final string: BIN + Range
            output.add(binStr + startStr + "," + binStr + endStr + "," + iv.brand);
        }

        return output;
    }

    // Helper method to merge adjacent intervals with the same brand
    private static List<Interval> mergeIntervals(List<Interval> input) {
        if (input.isEmpty()) return input;
        
        List<Interval> result = new ArrayList<>();
        Interval prev = input.get(0);
        
        for (int i = 1; i < input.size(); i++) {
            Interval curr = input.get(i);
            
            // Check if intervals are strictly adjacent AND have the same brand
            if (prev.end + 1 == curr.start && prev.brand.equals(curr.brand)) 
            {
                // Merge them: extend prev's end to curr's end
                prev.end = curr.end;
            } else {
                // Push the completed 'prev' and move to 'curr'
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;
    }
}