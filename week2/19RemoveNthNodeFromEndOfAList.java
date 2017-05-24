/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveNthNodeFromEndOfAListSolution {
    //Have no idea why this algorithnm ran so slow...
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode extraHeading=new ListNode(0);
        extraHeading.next=head;
        ListNode first=extraHeading,second=extraHeading;
        
        while(first.next!=null){
            first=first.next;
            if(n--<=0) 
                second=second.next;
        }
        
        if(second.next!=null) second.next=second.next.next;
        return extraHeading.next;
    }
}
