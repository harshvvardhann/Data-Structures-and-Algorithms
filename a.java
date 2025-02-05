class a {
    public int countPartitions(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int sumLeft = sum(nums,0,i);
            int sumRight = sum(nums,i+1,nums.length-1);
            if(sumLeft==0 || sumRight==0){
                continue;
            }
            if(Math.abs(sumLeft-sumRight)%2==0){
                count++;
            }
        }
        return count;
    }

    public int sum(int nums[],int start,int end){
        int sum = 0;
        for(int i=start;i<=end;i++){
            sum+=nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        a s = new a();
        int[] nums = {10,10,3,7,6};
        System.out.println(s.countPartitions(nums));
    }
}