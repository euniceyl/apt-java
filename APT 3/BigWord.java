import java.util.*;
import java.util.ArrayList;

public class BigWord {
    public static void main(String[] args) {
        BigWord abc = new BigWord();
        String[] sentences = {"one fish two", "fish red fish blue", "fish this fish is black"};
        String output = abc.most(sentences);
        System.out.println(output);
    }

    public String most(String[] sentences) {
        String wholeList = (String.join(" ", sentences)).toLowerCase();
        String[] words = wholeList.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            if (!map.keySet().contains(words[i])) {
                map.put(words[i], 1);
            }
            else {
                map.put(words[i], map.get(words[i])+1);
            }
        }

        int maximum = 0;
        String key = "";
        for (String s : map.keySet()) {
            if (map.get(s) > maximum) {
                maximum = map.get(s);
                key = s;
            }
        }
        return key;
    }
}