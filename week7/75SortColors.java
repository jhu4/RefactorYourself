public class SortColorsSolution {
    //This is actually bucket sort
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        
        int[] counting = new int[3];
        for(int i : nums) {
            counting[i]++;
        }
        
        int index = 0;
        for(int i = 0; i < 3; i++) {
            while(counting[i]>0) {
                nums[index++] = i;
                counting[i]--;
            }
        }
    }
}
