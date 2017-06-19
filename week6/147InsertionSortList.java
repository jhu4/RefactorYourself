/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class InsertionSortListSolution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        
        ListNode pre=dummy; //for the larger loop
        ListNode cur=head;
        
        ListNode slow; //for the smaller loop (the sorted loop)
        ListNode fast;
        while(cur!=null){
            if(pre.val<=cur.val){ //the element is already in order
                pre=pre.next;
                cur=cur.next;
            }
            else{
                pre.next=cur.next; //take the current node out of the linked list
                slow=dummy;
                fast=dummy.next;
                while(fast!=pre.next){ //iterate the smaller loop to find the insertion place
                    if(fast.val>cur.val){
                        slow.next=cur; //insert the current node
                        cur.next=fast;
                        break;
                    }
                    slow=slow.next; //move the ptrs
                    fast=fast.next;
                }
                cur=pre.next; //update the current node
            }
        }
        return dummy.next;
    }
}
