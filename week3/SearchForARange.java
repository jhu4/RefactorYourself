public class 34SearchForARangeSolution {
    //My initial solution
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        if(nums==null || nums.length==0) return res;
        
        int lo=0,hi=nums.length-1,mid=(lo+hi)/2;
        while(lo<=hi){
            if(nums[mid]==target){
                if((mid==0||nums[mid-1]!=target)&&(mid==nums.length-1||nums[mid+1]!=target)) return new int[]{mid,mid}; //edge case...one element
                else if(mid==0||nums[mid-1]!=target) return new int[]{mid,findRightIndex(nums,target,mid+1,hi)};
                else if(mid==nums.length-1||nums[mid+1]!=target) return new int[]{findLeftIndex(nums,target,lo,mid-1),mid};
                else return new int[]{findLeftIndex(nums,target,lo,mid-1),findRightIndex(nums,target,mid+1,hi)};
                
            }
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
            mid=(lo+hi)/2;
        }
        
        return res;
    }
    
    private int findLeftIndex(int[] nums, int target, int lo, int hi){
        int mid=(lo+hi)/2;
        
        while(lo<=hi){
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target) return mid;
                else hi=mid-1;
            }
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
            mid=(lo+hi)/2;
        }
        return -1;
    }
    
    private int findRightIndex(int[] nums, int target, int lo, int hi){
        int mid=(lo+hi)/2;
        
        while(lo<=hi){
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]!=target) return mid;
                else lo=mid+1;
            }
            else if(nums[mid]>target) hi=mid-1;
            else lo=mid+1;
            mid=(lo+hi)/2;
        }
        return -1;
    }
    
    
                
}
