package util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString(){
        ListNode tmp = this;
        StringBuffer sb = new StringBuffer();
        while (tmp != null) {
            sb.append(tmp.val);
            if (tmp.next != null) {
                sb.append("->");
            }
            tmp = tmp.next;
        }
        return sb.toString();
    }

}