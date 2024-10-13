import java.util.*;

public class Starter {
    public static void main(String[] args) {
        Starter abc = new Starter();
        String[] words = {"easy", "lies", "the", "head", "that", "wears", "yellow"};
        String first = "e";
        int output = abc.begins(words, first);
        System.out.println(output);
    }

    public int begins(String[] words, String first) {
        int firstLetterMatch = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (int k = 0; k < words.length; k += 1) {
            if (words[k].charAt(0) == first.charAt(0) && list.contains(words[k]) == false) {
                list.add(words[k]);
                firstLetterMatch += 1;
            }
        }

        if (firstLetterMatch > 0) {
            return firstLetterMatch;
        }
        else {
            return 0;
        }
    }
}