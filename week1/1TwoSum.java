import java.util.*;
public class TwoSumSolution {
    //My solution
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> map = new Hashtable<Integer,Integer>();
        int[] result= new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result[0]=map.get(nums[i]);
                result[1]=i;
                return result;
            }
            map.put(target-nums[i],i);
        }
        return result;
    }
    
    //Other's solution that is similar
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            } else {
                map.put(target - numbers[i], i);
            }
         }
         return new int[]{0, 0};
     }
}
