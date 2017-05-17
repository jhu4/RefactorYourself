public class AddTwoNumbersSolution {
    //My solution
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode ini=new ListNode(0);
        ListNode result=ini;
        boolean overflow=false;
        while(l1!=null || l2!=null || overflow){
            int one=0,two=0,sum;
            if(l1!=null){
                one=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                two=l2.val;
                l2=l2.next;
            }
            sum=overflow?one+two+1:one+two;
            if(sum>=10){
                sum-=10;
                overflow=true;
            }
            else{
                overflow=false;
            }
            ini.next=new ListNode(sum);
            ini=ini.next;
        }
        return result.next;
    }
    
    //Others code that is more consice
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
    
    //Another answer that I also appreciate
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
