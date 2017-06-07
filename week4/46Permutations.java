public class Solution {
    //Recursive solution
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        if(nums.length==1){
            res.add(new ArrayList<>(Arrays.asList(nums[0])));
            return res;
        }
        
        
        List<List<Integer>> recur=permute(Arrays.copyOfRange(nums,1,nums.length));
        
        int recurSize=recur.size();
        for(int i=0;i<recurSize;i++){ 
            List<Integer> cur=recur.get(i);
            for(int j=0;j<cur.size();j++){
                List<Integer> clone=new ArrayList<>(cur);
                clone.add(j,nums[0]);
                recur.add(clone);
            }
            cur.add(nums[0]);//the last one, do not need to clone
        }
        return recur;
    }
    
    //DP solution
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        
        res.add(new ArrayList<>(Arrays.asList(nums[0]))); 
        
        if(nums.length==1){
            return res;
        }
        
        for(int i=1;i<nums.length;i++){ //start with one because empty ArrayList is really hard to deal with
            int size=res.size(); //remember the size is changing so we have to extract the size before the condition
            for(int j=0;j<size;j++){ //j represents the jth list in the list
                List<Integer> cur=res.get(j);
                for(int k=0;k<cur.size();k++){ //k represents the kth element in the list
                    List<Integer> clone=new ArrayList<Integer>(cur);
                    clone.add(k,nums[i]);
                    res.add(clone);
                }
                cur.add(nums[i]);
            }
        }
        return res;
    }
    
    //Back tracking
    public List<List<Integer>> permute3(int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       // Arrays.sort(nums); // not necessary
       backtrack(list, new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
       if(tempList.size() == nums.length){
          list.add(new ArrayList<>(tempList));
       } else{
          for(int i = 0; i < nums.length; i++){ 
             if(tempList.contains(nums[i])) continue; // element already exists, skip
             tempList.add(nums[i]);
             backtrack(list, tempList, nums);
             tempList.remove(tempList.size() - 1);
          }
       }
} 
}
