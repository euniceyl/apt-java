import java.util.*;

public class SetAside {
    public static void main(String[] args) {
        SetAside abc = new SetAside();
        String[] list = {"blue blue water", "blue skies are blue", "blue is blue"};
        String output = abc.common(list);
        System.out.println(output);
    }

    public String common(String[] list) {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<list.length; i++) {
            String[] words = list[i].split(" ");
            Set<String> noDuplicate = new HashSet<>();
            for (String s : words) {
                noDuplicate.add(s);
            }
            for (String w : noDuplicate) {
                if (!map.containsKey(w)) {
                    map.put(w, 1);
                }
                else if (map.containsKey(w)) {
                    map.put(w, map.get(w) + 1);
                }
            }
        }

        ArrayList<String> output = new ArrayList<>();
        for (String n : map.keySet()) {
            if (map.get(n) == list.length) {
                output.add(n);
            }
        }
        String[] outputArray = output.toArray(new String[0]);
        Arrays.sort(outputArray);

        String finalOutput = "";
        for (int k=0; k<outputArray.length; k++) {
            if (k < outputArray.length - 1) {
                finalOutput += outputArray[k] + " ";
            }
            else if (k == outputArray.length - 1) {
                finalOutput += outputArray[k];
            }
        }
        return finalOutput;
    }
}