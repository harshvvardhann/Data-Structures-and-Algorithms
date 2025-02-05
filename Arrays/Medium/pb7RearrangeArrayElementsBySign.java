package Arrays.Medium;

public class pb7RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int newarr[] = new int[nums.length];
        int x = 0;
        int y = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                newarr[x] = nums[i];
                x += 2;
            } else if (nums[i] < 0) {
                newarr[y] = nums[i];
                y += 2;
            }
        }
        return newarr;
    }
}
