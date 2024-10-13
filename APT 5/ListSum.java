import java.util.*;

public class ListSum {

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

    public int sum(ListNode list, int thresh) {
        int totalSum = 0;
        if (list == null) {
            return 0;
        }
        ListNode first = list;
        while (first != null) {
            if (first.info > thresh) {
                totalSum = totalSum + first.info;
            }
            first = first.next;
        }
        return totalSum;
    }
}
