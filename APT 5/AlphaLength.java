import java.util.*;

public class AlphaLength {
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

    public ListNode create (String[] words) {
        HashSet<String> unique = new HashSet<>();
        for (String w : words) {
            unique.add(w);
        }
        int c = 0;
        String[] uniqueWords = new String[unique.size()];
        for (String u : unique) {
            uniqueWords[c] = u;
            c++;
        }
        Arrays.sort(uniqueWords);

        ListNode first = new ListNode(uniqueWords[0].length());
        ListNode current = first;
        for (int i=1; i<uniqueWords.length; i++) {
            int count = uniqueWords[i].length();
            current.next = new ListNode(count);
            current = current.next;
        }
        return first;
    }
}
