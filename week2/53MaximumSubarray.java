public class MaximumSubarraySolution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int max=Integer.MIN_VALUE,presum=0;
        
        for(int i=0;i<nums.length;i++){
            presum=nums[i]>presum+nums[i]?nums[i]:presum+nums[i];
            max=presum>max?presum:max;
        }
        return max;
    }
}
