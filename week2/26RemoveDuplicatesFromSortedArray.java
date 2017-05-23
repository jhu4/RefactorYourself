public class RemoveDuplicatesFromSortedArraySolution {
    //My solution
    public int removeDuplicates1(int[] nums) {
        if(nums.length==0) return 0;
        int count=1, prenum=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=prenum){
                nums[count]=nums[i];
                count++;
            }
            prenum=nums[i];
        }
        
        return count;
    }
    
    //Another neater solution
    public int removeDuplicates2(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int n : nums)
            if (n > nums[i-1])
                nums[i++] = n;
        return i;
    }
}
