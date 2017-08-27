//Recursion
public ListNode reverseInPairs(ListNode head) {
  if (head == null || head.next == null) {
    return head;
  }

  //e.g. A -> B -> C
  ListNode temp = head.next.next; // save C
  head.next.next = head; // A -> B -> A
  head = head.next; // B -> A

  head.next.next = reverseInPairs(temp); //B -> A -> reverse(C)

  return head;
}
