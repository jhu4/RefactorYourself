public class SearchInsertionPositionSolution {
    //I can use binary search to improve its time complexity(Although I initially didn't think of it)
    public int searchInsert(int[] nums, int target) {
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
        }
        return lo;
    }
}
