import java.util.*;

public class SortedFreqs {

    public class SortedFreqsComp implements Comparator<String> {
        public final Map<String, Integer> frequency;
        SortedFreqsComp(Map<String, Integer> frequencyMap) {
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
    
    public int[] freqs(String[] data) {
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

        Collections.sort(list, new SortedFreqsComp(map));
        String[] sArray = list.toArray(new String[0]);
        Arrays.sort(sArray);

        int[] intArray = new int[sArray.length];
        for (int j=0; j<sArray.length; j++) {
            intArray[j] = map.get(sArray[j]);
        }
        return intArray;
    }
}