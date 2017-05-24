import java.lang.Math;
public class ThreeSumClosestSolution {
    public int threeSumClosest(int[] nums, int target) {
        int res=nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int lo=i+1,hi=nums.length-1;
            while(lo<hi){
                int sum=nums[lo]+nums[hi]+nums[i];
                if(Math.abs(sum-target)<Math.abs(res-target)) res=sum;
                
                if(sum<target) lo++;
                else if(sum>target) hi--;
                else return sum;
            }
        }
        return res;
    }
}
