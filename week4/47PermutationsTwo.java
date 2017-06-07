public class PermutationsTwoSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        
        Arrays.sort(nums);
        backtracking(res,new ArrayList<>(),new boolean[nums.length],nums);
        return res;
    }
    
    private void backtracking(List<List<Integer>> res,List<Integer> temp,boolean[] used,int[] nums){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue; //when a number has the same value with its previous
            //we can use this number only if his previous is used 
            temp.add(nums[i]);
            used[i]=true;
            backtracking(res,temp,used,nums);
            used[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}
