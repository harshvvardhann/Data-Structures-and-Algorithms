package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class a3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> a = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {

            // if for i the element is already used then we should not select the same
            // element twice.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // this is one of my triplet for sure
                    List<Integer> x = Arrays.asList(nums[i], nums[j], nums[k]);
                    a.add(x);
                    j++;
                    k--;

                    // if there are more duplicate elements then we need to ignore them
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // k gets compared from the right side elements as it is coming from right side.
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return a;
    }
}