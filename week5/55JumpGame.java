public class JumpGameSolution {
    //My initial solution
    public boolean canJump(int[] nums) {
        int maxReach=0;
        
        for(int i=0;i<nums.length;i++){
            if(i>maxReach) return false; //where the current index is not reachable
            maxReach=Math.max(maxReach,i+nums[i]);
        }
        
        return true;
    }
}
