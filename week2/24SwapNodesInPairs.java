/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class SwapNodesInPairsSolution {
    //My solution
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy=new ListNode(0);
        extra.next=head;
        ListNode cur=dummy;
        
        while(cur.next!=null && cur.next.next!=null){
            ListNode firstnode=cur.next; //the copy of the 1st node in a pair
            cur.next=cur.next.next; //put the 2nd node in the postion of the first node
            firstnode.next=cur.next.next; //link the previous first node to the first node of next pair
            cur.next.next=firstnode; //link the new first node to the old first node
    
            cur=firstnode; //jump to the node prior to the next pair
        }
        return dummy.next;
    }
    
    //A recursive solution 
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }
}
