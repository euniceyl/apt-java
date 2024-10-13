import java.util.*;

public class PairDown {
    public static void main(String[] args) {
        PairDown abc = new PairDown();
        int[] list = {7, 2, 8, 9, 4, 13, 7, 1, 9, 10};
        int[] output = abc.fold(list);
        System.out.println(output);
    }
    public int[] fold(int[] list) {
        ArrayList<Integer> sumList = new ArrayList<>();
        for (int i=0; i<list.length; i++) {
            if (i%2 != 0) {
                sumList.add(list[i] + list[i-1]);
            }
            else if ((i%2 == 0) && (i == list.length-1)) {
                sumList.add(list[i]);
            }
        }
        
        int[] finalList = new int[sumList.size()];
        int count = 0;
        for (int s : sumList) {
            finalList[count] = s;
            count++;
        }

        return finalList;
    }
}
