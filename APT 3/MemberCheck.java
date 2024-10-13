import java.util.*;
import java.util.ArrayList;

public class MemberCheck {
    public static void main(String[] args) {
        MemberCheck abc = new MemberCheck();
        String[] club1 = {"JOHN","JOHN","FRED","PEG"};
        String[] club2 = {"PEG","GEORGE"};
        String[] club3 = {"GEORGE","DAVID"};
        String[] output = abc.whosDishonest(club1, club2, club3);
        System.out.println(output);
    }

    public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> overlap = new HashSet<>();

        for (int i=0; i<club1.length; i++) {
            map.put(club1[i], 1);
        }

        for (int i=0; i<club2.length; i++) {
            if (!map.keySet().contains(club2[i])) {
                map.put(club2[i], 2);
            }
            else {
                if (!overlap.contains(club2[i])) {
                    for (String s : club1) {
                        if (s.equals(club2[i])) {
                            overlap.add(club2[i]);
                        }
                    }
                }
            }
        }

        for (int i=0; i<club3.length; i++) {
            if (!map.keySet().contains(club3[i])) {
                map.put(club3[i], 3);
            }
            else {
                if (!overlap.contains(club3[i])) {
                    for (String s : club1) {
                        if (s.equals(club3[i])) {
                            overlap.add(club3[i]);
                        }
                    }
                    for (String s : club2) {
                        if (s.equals(club3[i])) {
                            overlap.add(club3[i]);
                        }
                    }
                }
            }
        }
        
        String[] alphabeticalOverlap = overlap.toArray(new String[0]);
        Arrays.sort(alphabeticalOverlap);
        return alphabeticalOverlap;
    }
}
