import java.util.*;

public class SortByFreqs {
    public static void main(String[] args) {
        SortByFreqs abc = new SortByFreqs();
        String[] data = {"a", "a", "b", "c"};
        String[] output = abc.sort(data);
        System.out.println(output);
    }

    public class SortByFreqsComp implements Comparator<String> {
        public final Map<String, Integer> frequency;
        SortByFreqsComp(Map<String, Integer> frequencyMap) {
            this.frequency = frequencyMap;
        }

        public int compare(String a, String b) {
            int freqDiff = frequency.get(b).compareTo(frequency.get(a));
            if (freqDiff != 0) {
                return freqDiff;
            }
            return a.compareTo(b);
        }
    }
    
    public String[] sort(String[] data) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for (int i=0; i<data.length; i++) {
            if (!map.keySet().contains(data[i])) {
                map.put(data[i], 1);
                set.add(data[i]);
            }
            else {
                map.put(data[i], map.get(data[i])+1);
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }

        Collections.sort(list, new SortByFreqsComp(map));
        String[] outputArray = list.toArray(new String[0]);
        return outputArray;
    }
}