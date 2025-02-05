package LearnBasicHashing;

import java.util.*;

public class countFrequencyOfElements {

    public static void main(String args[]) {

        int arr[] = { 10, 5, 10, 15, 10, 5 };
        int n = arr.length;
        Frequency(arr, n);
    }

    static void Frequency(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        // Traverse through map and print frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

// Overall Complexity
// The two loops (one for building the map and one for traversing it) do not
// nest, so their complexities add up:
// O(n)+O(n)=O(n).

// Space Complexity

// The space complexity is O(k)
// k is the number of unique elements in the array. This is because the HashMap
// stores each unique element as a key, along with its frequency as a value.