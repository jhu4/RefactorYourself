public ListNode insert(ListNode head, int value) {
  ListNode dummy = new ListNode(0), insertedNode = new ListNode(value), cur = dummy;
  dummy.next = head;

  while(cur.next != null && value > cur.next.value) { //this loop finds the insertion place
    cur = cur.next;
  }

  insertedNode.next = cur.next;
  cur.next = insertedNode;

  return dummy.next;
}
