/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  public ListNode merge(ListNode one, ListNode two) {
    if(one == null && two == null) {
      return null;
    }
    else if(one == null) {
      return two;
    }
    else if(two == null) {
      return one;
    }

    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;

    while(one != null || two != null) {
      if(two == null) {
        cur.next = one;
        one = one.next;
      }
      else if(one == null) {
        cur.next = two;
        two = two.next;
      }
      else if(one.value <= two.value) {
        cur.next = one;
        one = one.next;
      }
      else{
        cur.next = two;
        two = two.next;
      }
      cur = cur.next;
    }
    return dummy.next;
  }
}
