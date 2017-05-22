import java.lang.Math;
public class ContainerWithMostWaterSolution {
    //Algorithmic ideas from https://discuss.leetcode.com/topic/25004/easy-concise-java-o-n-solution-with-proof-and-explanation
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,max=0;
        while(left<right){
            max=Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                int preleft=height[left];
                while(height[left]<=preleft && left<right){
                    left++;
                }
            }
            else{
                int preright=height[right];
                while(height[right]<=preright && left<right){
                    right--;
                }
            }
        }
        return max;
    }
}
