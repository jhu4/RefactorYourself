public class FourSumSolution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        int len=nums.length;
        if(nums==null || len<4) return res;
        Arrays.sort(nums);
        if(4*nums[0]>target || 4*nums[len-1]<target) return res; //quickly return if the int[] is not a good candidate
        
        for(int i=0;i<len-3;i++){ //first element's loop
            if(i==0 || nums[i]!=nums[i-1]){ //avoid duplications
                for(int j=i+1;j<len-2;j++){ //second element's lopp
                    if(j==i+1 || nums[j]!=nums[j-1]){ //avoid duplications
                        int lo=j+1,hi=len-1;
                        while(lo<hi){ //last two elements' loop
                            int sum=nums[i]+nums[j]+nums[lo]+nums[hi];
                            if(sum<target){
                                lo++;
                                while(lo<hi && nums[lo]==nums[lo-1]) lo++; //avoid duplications
                            }
                            else if(sum>target){
                                hi--;
                                while(lo<hi && nums[hi]==nums[hi+1]) hi--; //avoid duplications
                            }
                            else{
                                List<Integer> four= new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                                res.add(four);
                                lo++;
                                hi--;
                                while(lo<hi && nums[lo]==nums[lo-1]) lo++; //avoid duplications
                                while(lo<hi && nums[hi]==nums[hi+1]) hi--; //avoid duplications
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
