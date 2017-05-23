/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedListsSolution {
    //itinerary method
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null && l2==null) return null;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode start=l1;
        if(l2.val<l1.val){
            start=l2;
            l2=l1;
            l1=start;
        }

        while(l1!=null && l1.next!=null){
            if(l1.next.val>l2.val){
                ListNode temp=l1.next;
                l1.next=l2;
                l2=temp;
                l1=l1.next;
            }
            else{
                l1=l1.next;
            }
        }
        l1.next=l2;
        return start;
    }
    
    //Recursion solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1==null && l2==null) return null;
      if(l1==null) return l2;
      if(l2==null) return l1;

      if(l1.val<l2.val){
          l1.next=mergeTwoLists(l1.next,l2);
          return l1;
      }
      else{
          l2.next=mergeTwoLists(l2.next,l1);
          return l2;
    }
}
