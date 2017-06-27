import java.io.*;
import java.util.*;

/**         Hacker Rank's question         **/
public class AlmostSortedSolution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0;i < n; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
             
        int start = -1, end = -1;
        int misplaced = 0;
        
        for(int i = 0; i < n - 1; i++) {
            if(array[i] > array[i + 1]) {
                misplaced++;
                if(start < 0) {
                    start = i;
                }
            }
        }
        
        for(int i = n - 1; i > 0; i--) {
            if(array[i] < array[i-1]) {
                end = i;
                break;
            }
        }
        
        if(misplaced < 1) {
            System.out.println("no");
            return;
        }
        else if(misplaced == 1 || misplaced == 2) {
            if(misplaced == 1)   //case where two neighbors swap themselves
                end = start + 1;
            boolean leftValidator = (start == 0 || array[end] >= array[start - 1]) && array[end] <= array[start + 1];
            boolean rightValidator = 
                (end == n - 1 || array[start] <= array[end + 1]) && array[start] >= array[end -1];
            if(leftValidator && rightValidator) {
                System.out.println("yes");
                System.out.println("swap "+(start+1)+" "+(end+1));
            }
            else{
                System.out.println("no");
            }
            return;
        }
        else{
            boolean leftValidator = start == 0 || array[end] >= array[start - 1];
            boolean rightValidator = end == n -1 || array[start] <= array[end + 1];
            if(!leftValidator || !rightValidator){
                System.out.println("no");
                return;
            }
            int pre = array[end];
            for(int i = end - 1; i >= start; i--) {
                if(array[i] < pre) {
                    System.out.println("no");
                    return;
                }
                pre = array[i];
            }
            
            System.out.println("yes");
            System.out.println("reverse "+(start+1)+" "+(end+1));
        }
        
        /**
        //I am such an idot cause I first understood the question wrongly
        //If the array was supposed to be consecutively ascending order, then the code below would've worked
        
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;
        int left = 0, right = n - 1;
        int misplaced = 0;
        
        for(int i : array) { //find the min value
            min = Math.min(min, i);
        }
        
        while(left <= right) { //find how many elements are misplaced and the index of first misplaced element
            if(array[left] != min + left) { //and the index of the last misplaced element
                misplaced++;
                if(start < 0) {
                    start = left;
                }
            }
            left++;
            if(left <= right && array[right] != min + right) { //left != right for the case where the array is odd
                misplaced++;
                if(end < 0) {
                    end = right;
                }
            }
            right--;
        }
        
        if(misplaced < 2) {
            System.out.println("no");
            return;
        }
        else if(misplaced == 2) {
            if(min + start == array[end] && min + end == array[start]) {
                System.out.println("yes");
                System.out.println("swap "+(start+1)+" "+(end+1));
            }
            else{
                System.out.println("no");
            }
            return;
        }
        else{
            for(int i = start, j = 0; i <= end; i++, j++) {
                if(array[i] != min + end - j) {
                    System.out.println("no");
                    return;
                }
            }
            
            System.out.println("yes");
            System.out.println("reverse "+(start+1)+" "+(end+1));
        }
        **/
        
    }
}
