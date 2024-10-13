import java.util.*;
import java.util.ArrayList;

public class Common {

    public int count(String a, String b) {
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        ArrayList<Character> newCharA = new ArrayList<>();
        for (int k=0; k<charA.length; k++) {
            newCharA.add(charA[k]);
        }
        ArrayList<Character> newCharB = new ArrayList<>();
        for (int k=0; k<charB.length; k++) {
            newCharB.add(charB[k]);
        }

        ArrayList<Character> commonChar = new ArrayList<>();
        int count = 0;
        for (int i=0; i<newCharA.size(); i++) {
            for (int j=0; j<newCharB.size(); j++) {
                if (newCharA.get(i) == newCharB.get(j)) {
                    commonChar.add(newCharA.get(i));
                    newCharB.remove(newCharB.get(j));
                    break;
                }
            }
        }
        count = commonChar.size();
        return count;
    }
}