public class FIFO {
  ListNode first, last;
  private class ListNode {
    int receiver;
    ListNode next;
    ListNode(int receiver) {
      this.receiver = receiver;
      next = null;
    }
  }

  public FIFO() {
    first = null;
    last = null;
  }

  public void addToFIFO(int receiver) {
    ListNode newNode = new ListNode(receiver);
    if (first == null) {
      last = newNode;
      first = last;
    }
    else {
      last.next = newNode;
      last = newNode;
    }
  }

  // returns id of the next receiver or -1 if there is no
  public int getNextReceiver() {
    int result;
    if (first != null) {
      result = first.receiver;
      //first = first.next;
    }
    else {
      result = -1;
    }
    return result;
  }
  public void dropNextReciever() {
	  if(first != null) {
		  first = first.next;
	  }
  }
  public boolean isempty() {
	  if (first != null) {
		  return false;
	  }
	  else {
		  return true;
	  }
  }
}
