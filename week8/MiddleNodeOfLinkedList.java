public ListNode middleNode1(ListNode head) {
  if(head == null || head.next == null) {
    return head;
  }

  ListNode slow = head, fast = head;

  while(fast.next != null && fast.next.next != null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}

public ListNode middleNode2(ListNode head) {
  if(head == null || head.next == null) {
    return head;
  }

  ListNode dummy = new ListNode(0);
  dummy.next = head;

  ListNode slow = dummy, fast = dummy;

  while(fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}
