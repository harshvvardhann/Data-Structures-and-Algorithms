package PriorityQueue;
import java.util.PriorityQueue;
import java.util.Collections;
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//descnding order
        for(int num:stones){
            pq.add(num);
        }

        while(pq.size()>1){
            int a = pq.poll();//heaviest
            int b = pq.poll();//second heaviest

            if(a!=b){
                pq.add(a-b);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}