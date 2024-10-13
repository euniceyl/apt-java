import java.util.*;

public class Closet {
    public static void main(String[] args) {
        Closet abc = new Closet();
        String[] list = {"a b c d", "b c d", "b c d e", "b c f"};
        String output = abc.anywhere(list);
        System.out.println(output);
    }
    public String anywhere(String[] list) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<list.length; i++) {
            String[] words = list[i].split(" ");
            for (int j=0; j<words.length; j++) {
                set.add(words[j]);
            }
        }

        String[] alphabetical = set.toArray(new String[0]);
        Arrays.sort(alphabetical);
        
        String alphabeticalFinal = "";
        for (int k=0; k<alphabetical.length; k++) {
            if (k < alphabetical.length - 1) {
                alphabeticalFinal += alphabetical[k] + " ";
            }
            else if (k == alphabetical.length - 1) {
                alphabeticalFinal += alphabetical[k];
            }
        }
        return alphabeticalFinal;
    }
}