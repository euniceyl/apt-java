import java.util.*;

public class OlympicCandles {
    public int numberOfNights(int[] candles) {
        int night = 1;
        while (true) {
            Arrays.sort(candles);
            for (int i=0; i<night; i++) {
                int index = candles.length - (i+1);
                if (index < 0 || candles[index] == 0) {
                    return night - 1;
                }
                else {
                    candles[index] = candles[index] - 1;
                }
            }
            night++;
        }
    }
}
