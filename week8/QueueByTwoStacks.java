public class Solution {
  Stack<Integer> storing;
  Stack<Integer> offering;
  
  public Solution() {
    this.storing = new Stack<>();
    this.offering = new Stack<>();
  }

  public Integer poll() {
    if(offering.empty()) {
      fillOffering();
    }
    try{
      return offering.pop();
    }
    catch(EmptyStackException e) {
      return null;
    }
  }

  public void offer(int element) {
    storing.push(element);
  }

  public Integer peek() {
    if(offering.empty()) {
      fillOffering();
    }
    try{
      return offering.peek();
    }
    catch(EmptyStackException e) {
      return null;
    }
  }

  public int size() {
    return offering.size() + storing.size();
  }

  public boolean isEmpty() {
    return offering.empty() && storing.empty();
  }

  private void fillOffering() {
    while(!storing.empty()) {
      offering.push(storing.pop());
    }
  }
}
