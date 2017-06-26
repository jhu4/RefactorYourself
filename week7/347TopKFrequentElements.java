public class TopKFrequentElementsSolution {
    //O(n) solution using map and bucket sort
    public List<Integer> topKFrequent1(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1]; //we use a list because they might be more than one elements having
        Map<Integer, Integer> freq = new HashMap<>();   //having the same frequency
        
        for(int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        
        for(int key : freq.keySet()) {
            int frequency = freq.get(key);
            if(bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if(bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        
        return res;
    }
}
