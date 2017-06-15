public class Solution {
    //Test cases: [1] [2,1,1] [2,0,0,1,4] [2,4,0,1,0] [2,4,0,1,0,1,0]
    //My initial solution -> greedy
    public int jump(int[] nums) {
        if(nums==null||nums.length<=1) return 0;
        
        int maxReach=nums[0],cur=0,jump=1;
        
        while(maxReach<nums.length-1){
            int curMaxReach=maxReach;
            for(int i=cur+1;i<=curMaxReach;i++){
                maxReach=Math.max(maxReach,nums[i]+i);
            }
            cur=nums[cur]+cur;
            maxReach=Math.max(cur+1,maxReach);//in case where the jumping area are all zero
            jump++;
        }
        
        return jump;
    }
    
    //Other's solution
    //The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd]
    // curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
    //Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest
    //then keep the above steps, as the following
    public int jump2(int[] nums) {
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;
        //calculate for each position
        for (int i = 0; i< nums.length - 1; i ++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                curEnd = curFarthest;
                jumps++;
            }
        }
        return jumps;
    }
}
