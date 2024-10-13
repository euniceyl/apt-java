import java.util.*;

public class LengthSort {
    private class LengthSortComp implements Comparator<String> {
        public int compare(String a, String b) {
            int lengthDiff = a.length() - b.length();
            if (lengthDiff != 0) {
                return lengthDiff;
            }
            return a.compareTo(b);
        }
    }

    public String[] rearrange(String[] values) {
        Arrays.sort(values, new LengthSortComp());
        return values;
    }
}
