//Recursion
public ListNode reverse1(ListNode head) {
  if(head == null || head.next == null) return head;

  ListNode reversedTail = head.next;
  ListNode reversedHead = reverse(head.next);
  reversedTail.next = head;
  head.next = null;

  return reversedHead;
}

//Iteration
public ListNode reverse2(ListNode head) {
  if(head == null || head.next == null) return head;

  ListNode reversed = null;
  ListNode temp;

  while(head != null) {
    temp = head;
    head = head.next; //take out the current Node from the orginal list
    temp.next = reversed; //add the current Node to the head of reversed list
    reversed = temp; //update the head Node of the reversed list
  }
  return reversed;
}
