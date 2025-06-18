package PriorityQueue;
import java.util.PriorityQueue;
import java.util.Collections;

class kthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }

        int num = -1;
        while(k>0){
            num = pq.poll();
            k--;
        }

        return num;
    }
}