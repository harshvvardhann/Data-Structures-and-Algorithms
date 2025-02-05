package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;

// The problem in this solution is when the elements are duplicates in the array then in the hashmap the value will override the index so will get the wrong answer
public class pb1TwoSum {

    public static int[] check(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            a.put(arr[i], i);
        }
        Arrays.sort(arr);
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return new int[] { a.get(arr[left]), a.get(arr[right]) };
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] arr = { 3, 3 };
        int index[] = check(arr, 6);
        for (Integer x : index) {
            System.out.println(x);
        }
    }
}




// import java.util.*;

// public class tUf {
//     public static String twoSum(int n, int []arr, int target) {
//         HashMap<Integer, Integer> mpp = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             int num = arr[i];
//             int moreNeeded = target - num;
//             if (mpp.containsKey(moreNeeded)) {
//                 return "YES";
//             }

//             mpp.put(arr[i], i);
//         }
//         return "NO";
//     }

//     public static void main(String args[]) {
//         int n = 5;
//         int[] arr = {2, 6, 5, 8, 11};
//         int target = 14;
//         String ans = twoSum(n, arr, target);
//         System.out.println("This is the answer for variant 1: " + ans);
//     }

// }

// TC: O(N) and SC:O(1)