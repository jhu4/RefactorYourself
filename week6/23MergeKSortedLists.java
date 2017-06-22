/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedListsSolution {
      /**
       I used this solution to practice heap sort...
       There are few things need to be concerned:
       1. The top-uped ListNode should be from the same list that the previous top of the heap is from
       2. We don't need to track where the node from since they are linked lists... we only need to call node.next to
          access the next node
       3. Heap index starts from 1 instead of 0
      **/
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode it = dummy;
        ListNode[] heap = new ListNode[lists.length + 1]; //length + 1 becasue heap index start with 1
        
        int heapIndex = 0; //the first element of the heap start with 1
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                heap[++heapIndex] = lists[i]; //put the node in the heap
            }
        }
        if(heapIndex == 0) return null; //the list doesn't contains any node
        buildHeap(heap, heapIndex);
        
        while(heapIndex > 0) {
            it.next = heap[1]; //link the result to the new min
            it = it.next;
            heap[1] = heap[1].next;
            if(heap[1] == null) {
                heap[1] = heap[heapIndex--]; //swap with the last element and decrease the size
            }
            heapify(heap, 1, heapIndex);
        }
        
        return dummy.next;
    }
    
    
    private void buildHeap(ListNode[] heap, int end) {
        for(int i = end/2; i>= 1; i--){
            heapify(heap, i, end);
        }
    }
    
    private void heapify(ListNode[] heap, int start, int end) {
        if(start >= end) return;
        ListNode temp;
        int min = start;
        int left = 2 * start;
        int right = 2 * start + 1;
        
        if(left <= end && heap[left].val < heap[min].val) {
            min = left;
        }
        if(right <= end && heap[right].val < heap[min].val) {
            min = right;
        }
        
        if(min != start) { 
            temp = heap[start]; //swap the min to the top
            heap[start] = heap[min];
            heap[min] = temp;
            heapify(heap, min, end); //heapify the remaining only if we swap elements
        }
    }
}
