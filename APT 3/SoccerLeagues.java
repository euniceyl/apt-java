import java.util.*;

public class SoccerLeagues {
    public static void main(String[] args) {
        SoccerLeagues abc = new SoccerLeagues();
        String[] matches = {"-DD", "L-L", "WD-"};
        int[] output = abc.points(matches);
        System.out.println(output);
    }
    public int[] points(String[] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k=0; k<matches.length; k++) {
            map.put(k, 0);
        }

        for (int i=0; i<matches.length; i++) {
            for (int j=0; j<matches.length; j++) {
                if (matches[i].charAt(j) == 'W') {
                    map.put(i, map.get(i) + 3);
                }
                else if (matches[i].charAt(j) == 'D') {
                    map.put(i, map.get(i) + 1);
                    map.put(j, map.get(j) + 1);
                }
                else if (matches[i].charAt(j) == 'L') {
                    map.put(j, map.get(j) + 3);
                }
            }
        }

        int counter = 1;
        int[] point = new int[matches.length];
        for (int p : map.keySet()) {
            if (p < counter && p >= (counter - 1)) {
                point[p] = map.get(p);
            }
            counter++;
        }
        return point;
    }
}