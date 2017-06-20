/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SortListSolution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        
        
        ListNode slow=head;
        ListNode fast=head.next.next;
        
        while(fast!=null&&fast.next!=null){ //find the middle element in the linked list
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode half=slow.next; //separate the list
        slow.next=null;
        
        return merge(sortList(head),sortList(half));
    }
    
    
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
            }
            else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l1!=null)
            head.next=l1;
        if(l2!=null)
            head.next=l2;
        
        return dummy.next;
    }
}
