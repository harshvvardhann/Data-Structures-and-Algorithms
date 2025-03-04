package ContestProblems.ContestProblems; 
class FindLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        int arr[] = new int[51];
        for(int x:nums) arr[x]++;

        if(k == 1){
            for(int i=50;i>=0;i--){
                if(arr[i] == 1) return i;
            }
            return -1;
        }
        if(k == nums.length){
            for(int i=50;i>=0;i--){
                if(arr[i] != 0) return i;
            }
        }

        int num1 = nums[0];
        int num2 = nums[nums.length-1];

        boolean a = arr[num1] == 1;//element appears only once
        boolean b = arr[num2] == 1;//element appears only once
        boolean c = num1 == num2;//both element are same

        if(c) return -1;//if both same no ans possible
        if(a && b) return Math.max(num1,num2);//if both appears only once then return max

        //if code goes till here that means there possible that 1 out of both element
        //num1 and num2 might be appearing twice so we have to check..
        if(a) return num1;
        if(b) return num2;
        
        //if code goes here that means there is no ans possible
        return -1;
    }
}