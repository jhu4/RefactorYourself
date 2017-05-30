/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListSolution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        
        ListNode cpy=head;
        while(cpy!=null){
            while(cpy.next!=null && cpy.next.val==cpy.val) cpy.next=cpy.next.next;
            cpy=cpy.next;
        }
        return head;
    }
}
