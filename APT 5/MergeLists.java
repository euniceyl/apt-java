import java.util.*;

public class MergeLists {
    public class ListNode {
        int info;
        ListNode next;
        ListNode(int x){
            info = x;
        }
        ListNode(int x, ListNode node){
            info = x;
            next = node;
        }
    }

    public ListNode weave (ListNode a, ListNode b) {
        ListNode aFirst = new ListNode(a.info);
        ListNode bFirst = new ListNode(b.info);
        ListNode current = aFirst;
        current.next = bFirst;
        current = current.next;

        while (a.next != null && b.next != null) {
            current.next = new ListNode(a.next.info);
            current = current.next;
            a = a.next;
            current.next = new ListNode(b.next.info);
            current = current.next;
            b = b.next;
        }
        return aFirst;
    }
}
