package Arrays.Medium;

import java.util.HashSet;

public class pb10LongestSequence {
    public static int longestSequence(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int longest = 1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        for (Integer i : arr) {
            if (!set.contains(i)) {
                int count = 1;
                int element = i;
                while (set.contains(element + 1)) {
                    element = element + 1;
                    count = count + 1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;

    }
}
