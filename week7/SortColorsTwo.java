class SortColorsTwoSolution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    //This is actually based on bucket sort
    public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length <= 1) return;
        
        int[] numberCount = new int[k+1];
        for(int i : colors) {
            numberCount[i]++;
        }
        
        int index = 0;
        for(int i = 0; i < numberCount.length; i++) {
            while(numberCount[i] > 0) {
                colors[index++] = i;
                numberCount[i]--;
            }
        }
    }
}
