import java.util.*;

public class SimpleWordGame {
    public static void main(String[] args) {
        SimpleWordGame abc = new SimpleWordGame();
        String[] player = {"apple", "orange", "strawberry"};
        String[] dictionary = {"strawberry", "orange", "grapefruit", "watermelon"};
        int output = abc.points(player, dictionary);
        System.out.println(output);
    }

    public int points(String[] player, String[] dictionary) {
        int score = 0;
        HashSet<String> set = new HashSet<>();
        for (String s : player) {
            for (int i=0; i<dictionary.length; ++i) {
                if (dictionary[i].equals(s) && !set.contains(s)) {
                    set.add(s);
                }
            }
        }

        for (String s : set) {
            score += s.length()*s.length();
        }
        return score;
    }
}