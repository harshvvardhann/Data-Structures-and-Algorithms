package Arrays.Medium;

import java.util.*;

public class pb9ArrayLeader {
    public static ArrayList<Integer> arrayLeader(int arr[]) {
        ArrayList<Integer> a = new ArrayList<>();
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                a.add(arr[i]);
                max = arr[i];
            }
        }
        Collections.reverse(a);
        return a;
    }

    public static void main(String[] args) {
        int arr[] = { 30, 10, 10, 5 };
        ArrayList<Integer> a = arrayLeader(arr);
        System.out.println(a);
    }
}
