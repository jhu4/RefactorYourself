public class ThreeSumSolution {
    //Have no idea why this is so slower   Time Complexity: O(n^2)
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums); //O(nlogn)
        List<List<Integer>> result=new ArrayList<List<Integer>>(); 
        
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || nums[i]!=nums[i-1]){
                int lo=i+1,hi=nums.length-1,goal=-nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi]==goal) {
                        result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        lo++;
                        hi--;
                        while(lo<hi && nums[lo]==nums[lo-1]) lo++; //skip duplicates
                        while(lo<hi && nums[hi]==nums[hi+1]) hi--; //skip duplicates
                    }
                    else if(nums[lo]+nums[hi]<goal){
                        lo++;
                        while(lo<hi && nums[lo]==nums[lo-1]) lo++; //skip duplicates
                    }
                    else{
                        hi--;
                        while(lo<hi && nums[hi]==nums[hi+1]) hi--; //skip duplicates
                    }
                }
            }
        }
        return result;
    }
}
