package Arrays.Medium;

/* SOLUTION-1:BETTER: traverse through the array first and count seperately the number of 0's,1's,2's and store them in seperate variables then loop to all the three variables seperately like at first loop till count0 and add the 0's first and then do same for 1's and 2's. TC: O(N)-for traversing the array 1st time to calculate the count0,count1,count2. and O(N)-overall for using for loop 3 times for seperately count0,count1,count2. so overall O(2N).*/

/* DUTCH NATIONAL FLAG ALGORITHM: the algo will be using 3 pointers.. low,mid,high.
    The algo is based on 3 rule.. 0-low-1 will be 0's , low to mid-1 will be 1's and  high+1----n-1 for 2's. mid-high will be filled with random numbers 0/1/2 and in unsorted way.

    At start our mid is at 0 and high at the end because all are now randomly oriented so mid should be at first and low is also at 0.

    Now we can say that array is sorted from 0 to low-1 as it contains 0 only.. and also low to mid-1 it is sorted bcoz it contains 1 only so from 0 to mid-1 whole part is sorted and now mid to high is not sorted as it is out original array with random numbers and again high+1 to n-1 it is sorted as it contains onlly 2's.. so if somehow i manage to sort the portion of mid-high then my task will be easy.

    -CASE-1: if arr[mid]==0, in this case to arrange it in sorted order we have to put it in 1st part 0 - low-1 as it contains 0's only so what we wil do is swap with arr[low] as it contains 1 so if we swap it then now we will have 0 - low as 0's and low+1 to mid as 1's.. so now which part is unsorted the element after mid+1 to high.

    -re arranging the pointers after swapping as unsorted part is now mid-high only. And also updating the low pointer to +1 as 0 – low-1 should contain 0’s and low-mid-1 should contain 1’s. so that’s how only we will update the pointers by swapping the values in case of 0 and 2. Bcoz if it is 1 then we no need to swap and just need to update the pointer means increment the mid-1 pointer as the middle portion will only contain 1’s and if it is 2 then we will arrange it in the right part with 2’s and will arrange the pointers according to that.
 * 
 * 
 */

public class pb2SortColors {

    // SOLUTION-1: BETTER
    public static int[] sortedArray(int arr[]) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            arr[i] = 0;
        }
        for (int i = count0; i < count1; i++) {
            arr[i] = 0;
        }
        for (int i = count1; i < count2; i++) {
            arr[i] = 0;
        }

        return arr;
    }

    // SOLUTION-2 OPTIMAL: TC:O(N) as in each iteration we are sorting 1 element and
    // SC:O(1)
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

}
