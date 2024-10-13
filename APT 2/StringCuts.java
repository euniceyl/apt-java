import java.util.ArrayList;

public class StringCuts {

    public static void main(String[] args) {
        StringCuts abc = new StringCuts();
        String[] list = {"huge", "enormous", "big", "gigantic"};
        int minLength = 5;
        String[] output = abc.filter(list, minLength);
        System.out.println(output);
    }
    
    public String[] filter(String[] list, int minLength) {
        ArrayList<String> set = new ArrayList<>();
        for (String s : list) {
            for (int i=0; i<list.length; ++i) {
                if (list[i].length() >= minLength && !set.contains(list[i])) {
                    set.add(list[i]);
                }
            }
        }
        String[] filteredWord = new String[set.size()];
        for (int k=0; k<set.size(); k++) {
            filteredWord[k] = set.get(k);
        }
        return filteredWord;
    }
}