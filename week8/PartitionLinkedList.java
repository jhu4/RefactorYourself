public ListNode partition(ListNode head, int target) {
  if(head == null || head.next == null) {
    return head;
  }

  ListNode smaller = new ListNode(0), smallerIterator = smaller;
  ListNode other = new ListNode(0), otherIterator = other;

  while(head != null) {
    if(head.value < target) {
      smallerIterator.next = head;
      smallerIterator = smallerIterator.next;
    }
    else {
      otherIterator.next = head;
      otherIterator = otherIterator.next;
    }
    head = head.next;
  }

  smallerIterator.next = other.next;
  otherIterator.next = null; // end the linked

  return smaller.next;
}
