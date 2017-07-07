public boolean hasCycle(ListNode head) {
  if(head == null || head.next == null) {
    return false;
  }

  ListNode slow = head, fast = head.next;

  while(fast != null && fast.next != null) {
    if(slow.equals(fast)) { //equals for checking objects
      return true;
    }
    slow = slow.next;
    fast = fast.next.next;
  }

  return false;
}
