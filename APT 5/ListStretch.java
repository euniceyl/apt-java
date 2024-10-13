import java.util.*;

public class ListStretch {
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

    public ListNode stretch (ListNode list, int amount) {
        ListNode first = new ListNode(0);
        ListNode current = first;
        while (list != null) {
            for (int i=0; i<amount; i++) {
                current.next = new ListNode(list.info);
                current = current.next;
            }
            list = list.next;
        }
        return first.next;
    }
}
