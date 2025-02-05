package Arrays.Easy;

class pb3IsArraySorted {
    public boolean check(int[] nums) {
        int count = 0;
        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                break;
            }
        }
        if (count == 1 || count == 0) {
            return true;
        } else {
            return false;
        }
    }
}