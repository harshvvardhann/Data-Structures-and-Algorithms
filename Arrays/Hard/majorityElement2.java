package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                count1++;
                ele1 = nums[i];
            } else if (count2 == 0 && ele1 != nums[i]) {
                count2++;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            }
        }
        int mini = (int) n / 3 + 1;
        if (count1 >= mini) {
            a.add(ele1);
        }
        if (count2 >= mini) {
            a.add(ele2);
        }
        return a;
    }
}