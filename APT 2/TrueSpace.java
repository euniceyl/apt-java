import java.util.*;
import java.util.ArrayList;

public class TrueSpace {

    public long calculateSpace(int[] sizes, int clusterSize) {
        long memory = 0;
        for (int i=0; i<sizes.length; i++) {
            if (sizes[i] % clusterSize != 0) {
                memory = memory + (sizes[i] / clusterSize) + 1;
            }
            else {
                if (sizes[i] != 0) {
                    memory = memory + (sizes[i] / clusterSize);
                }
            }
        }
        return clusterSize * memory;
    }
}