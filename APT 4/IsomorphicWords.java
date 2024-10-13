import java.util.*;

public class IsomorphicWords {
    public static void main(String[] args) {
        IsomorphicWords abc = new IsomorphicWords();
        String[] words = {"abca", "zbxz", "opqr"};
        int output = abc.countPairs(words);
        System.out.println(output);
    }

    public int countPairs(String[] words) {
        int totalCount = 0;
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words.length; j++) {
                Map<Character, Character> map = new HashMap<>();
                int count = 0;
                for (int k=0; k<words[i].length(); k++) {
                    if (!map.containsKey(words[i].charAt(k))) {
                        if (!map.values().contains(words[j].charAt(k))) {
                            map.put(words[i].charAt(k), words[j].charAt(k));
                            count++;
                        }
                    }
                    else if (map.containsKey(words[i].charAt(k))) {
                        if (map.get(words[i].charAt(k)) == words[j].charAt(k)) {
                            count++;
                        }
                    }
                }
                if (words[i].length() == count) {
                    totalCount++;
                }
            }
        }
        return (totalCount - words.length) / 2;
    }
}