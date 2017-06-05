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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        
        res.add(new ArrayList<>(Arrays.asList(nums[0]))); 
        
        if(nums.length==1){
            return res;
        }
        
        for(int i=1;i<nums.length;i++){
            int size=res.size(); //remember the size is changing so we have to extract the size before the condition
            for(int j=0;j<size;j++){
                List<Integer> cur=res.get(j);
                for(int k=0;k<cur.size();k++){
                    List<Integer> clone=new ArrayList<Integer>(cur);
                    clone.add(k,nums[i]);
                    res.add(clone);
                }
                cur.add(nums[i]);
            }
        }
        return res;
    }
}
