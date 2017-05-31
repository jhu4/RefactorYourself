public class SearchInRotatedSortedArraySolution {
    //My initial solution... ran slowly
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        if(nums.length<=10) return normalSearch(nums,target);
        else if(nums[0]>nums[nums.length-1]) return rotateBinarySearch(nums,target); 
        else return normalBinarySearch(nums,target);
    }
    
    private int normalSearch(int[] nums, int target){
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]) return i;
        }
        return -1;
    }
    
    private int normalBinarySearch(int[] nums, int target){
        if(target<nums[0]||target>nums[nums.length-1]) return -1;
        int lo=0,hi=nums.length-1,mid=0;
        
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
    
    private int rotateBinarySearch(int[] nums, int target){
        int lo=0,hi=nums.length-1,mid=0;
        
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(nums[mid]>nums[mid+1]) break;   //find the rotate index
            else if(nums[mid]>nums[nums.length-1]) lo=mid+1; //if mid is greater than than the last number, it means the range is left tilted
            else hi=mid-1;
        }
        
        if(target<=nums[mid]&&target>=nums[0]){
            lo=0;
            hi=mid;
        }
        else if(target>=nums[mid+1]&&target<=nums[nums.length-1]){
            lo=mid+1;
            hi=nums.length-1;
        }
        else return -1;
        
        
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}
