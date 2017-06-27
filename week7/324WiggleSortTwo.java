public class WiggleSortTwoSolution {
    /**Time complexity O(nlogn)
       Trick for this one: We can group numbers into medium, smaller and larger
                    odd:  M  M  M  S  S  S  S
                    even:  L  L  L  M  M  M  M
       Attention: it doesn't work reversly
                    odd:  L  L  L  M  M  M  M
                    even:  M  M  M  S  S  S  S
       There is an O(n) solution but it is too hard to explain https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
    **/
    public void wiggleSortTwo(int[] nums) {
        if(nums == null && nums.length <=1) return;
        int[] cpy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cpy);
        
        int left = nums.length % 2 == 0 ? nums.length / 2 - 1: nums.length / 2;
        int right = nums.length - 1;
        
        for(int i = 0; i + 1 < nums.length; i += 2) {
            nums[i] = cpy[left--];
            nums[i + 1] = cpy[right--];
        }
        
        if(nums.length % 2 == 1) { //if this is odd... add the last smaller number into the array
            nums[nums.length - 1] = cpy[left];
        }
    }
}
