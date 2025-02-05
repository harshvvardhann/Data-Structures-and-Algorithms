package Arrays.Easy;

import java.util.HashMap;

public class pb13MaxLenSubarray {

    public static int maxLenSubarray(int arr[], int k) {
        int sum = 0;
        int maxlen = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // adding array elements to the sum..
            sum += arr[i];

            // if sum=k then calculate the length from 1 to i+1
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }

            // now we may get the sum in between of the array also so for example if sum
            // from index 0 to 5 is 15 and we want sum to be 3 so we will try to find out
            // that if there exist any previous sum 15-3=12 in the array and if it is then
            // we can calculate our array length.
            int newsum = sum - k;
            if (a.containsKey(newsum)) {
                maxlen = Math.max(maxlen, i - a.get(newsum));
            }

            // we will add the sum only if it does not exist because we want the maximum
            // lenght of array and if we add the same sum again and again then it will
            // update the index also and that will lead to lesser the array size as for
            // example take the example used below only and iterate you will get it.
            if (!a.containsKey(sum)) {
                a.put(sum, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 0, 0, 3 };

        // int arr[] = { -1, -2, -3, 5, 6, 7 };
        System.out.println(maxLenSubarray(arr, 0));
    }
}
