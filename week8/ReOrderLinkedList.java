public ListNode reorder(ListNode head) {
  if(head == null || head.next == null) {
    return head;
  }

  ListNode mid = findMidNode(head), reversed = reverseLinkedList(mid.next);
  mid.next = null;
  ListNode it = head, temp;

  while(reversed != null) {
    temp = reversed.next;
    reversed.next = it.next;
    it.next = reversed;
    it = it.next.next; //update the iterator
    reversed = temp; //update the head of the reversed half of the LinkedList
  }

  return head;
}

private ListNode findMidNode(ListNode head) {
  ListNode slow = head, fast = head.next;

  while(fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
  }

  return slow;
}

private ListNode reverseLinkedList(ListNode head) {
  if(head == null || head.next == null) {
    return head;
  }

  ListNode reversed = null, temp;

  while(head != null) {
    temp = head; //take off the current node
    head = head.next;
    temp.next = reversed;
    reversed = temp;
  }

  return reversed;
}
