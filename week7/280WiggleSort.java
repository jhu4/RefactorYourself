public class WiggleSortSolution { //also can find it in Lintcode
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if(nums == null) return;
        Arrays.sort(nums);
        // quickSort(nums, 0, nums.length - 1); //Oh well, my quick sort is not fast enough
        if(nums.length<=2) return;
        
        int left = 1;
        int right;
        int temp;
        if(nums.length % 2 == 0) { //even elements v.s. odd elements
            right = nums.length - 2;
        }
        else {
            right =  nums.length - 1;    
        }
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 2;
            right -= 2;
        }
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = nums[start + (end - start) / 2];
        int left = start;
        int right = end - 1;
        int temp;
        
        nums[start + (end - start) / 2] = nums[end];
        nums[end] = pivot;
        
        
        while(left <= right) { //when the array only contains two element. Left and right pointers are going to point to the same element
            while(left < end && nums[left] <= pivot) left++;
            while(right > 0 && nums[right] > pivot) right--;
            
            if(left < right){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        
      
        nums[end] = nums[left];
        nums[left] = pivot;
        
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }
}
