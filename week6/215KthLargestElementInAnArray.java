public class KthLargestElementInAnArraySolution {
    //My initial attempt! beats 95% >w<!!!!!!!!!!!!
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums,k-1,0,nums.length-1);
    }
    
    private int findKthLargest(int[] nums,int k,int left, int right){
        int midNumber=nums[(left+right)/2]; //swap the partition element to the end of this section of the array
        nums[(left+right)/2]=nums[right];
        nums[right]=midNumber;
        
        int movingLeft=left;
        int movingRight=right-1; //right-1 because we just swapped the partition element to the end
        int temp;
        
        while(movingLeft<=movingRight){ //going through the array, put larger elements in the left and smaller elements in the right 
            while(movingLeft<right && nums[movingLeft]>=midNumber) movingLeft++; //find a smaller element in the left part
            while(movingRight>=left && nums[movingRight]<midNumber) movingRight--; //find a larger element in the right part
            if(movingLeft<movingRight){ //at the end they'll pass each other so we need to check this condition 
                temp=nums[movingLeft]; //swap them
                nums[movingLeft]=nums[movingRight];
                nums[movingRight]=temp;
            }
        }
        
        int partitionRank=movingLeft-left;
        if(partitionRank==k) return midNumber;
        else if(partitionRank>k) return findKthLargest(nums,k,left, movingLeft-1);
        else return findKthLargest(nums,k-(partitionRank+1),movingLeft,right-1);
    }
}
