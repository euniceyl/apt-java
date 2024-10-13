import java.util.*;

public class MedalTable {
    private class MedalCountry {
        String myName;
        int myGold;
        int mySilver;
        int myBronze;
        MedalCountry(String name) {
            myName = name;
        }
        public int getGold() {
            return myGold;
        }
        public int getSilver() {
            return mySilver;
        }
        public int getBronze() {
            return myBronze;
        }
        public String getName() {
            return myName;
        }
        @Override
        public String toString() {
            return String.format("%s %d %d %d", myName, myGold, mySilver, myBronze);
        }
    }

    public String[] generate(String[] results) {
        Map<String, MedalCountry> map = new HashMap<>();
        for (String s : results) {
            String[] data = s.split(" ");
            for (String c : data) {
                if (!map.containsKey(c)) {
                    map.put(c, new MedalCountry(c));
                }
            }
            map.get(data[0]).myGold += 1;
            map.get(data[1]).mySilver += 1;
            map.get(data[2]).myBronze += 1;
        }

        ArrayList<MedalCountry> list = new ArrayList<>(map.values());
        Comparator<MedalCountry> gold = Comparator.comparing(MedalCountry::getGold).reversed();
        Comparator<MedalCountry> silver = Comparator.comparing(MedalCountry::getSilver).reversed();
        Comparator<MedalCountry> bronze = Comparator.comparing(MedalCountry::getBronze).reversed();
        Comparator<MedalCountry> country = Comparator.comparing(MedalCountry::getName);
        Comparator<MedalCountry> comp = gold.thenComparing(silver).thenComparing(bronze).thenComparing(country);
        Collections.sort(list, comp);

        String[] medalArray = new String[list.size()];
        int counter = 0;
        for (MedalCountry l : list) {
            medalArray[counter] = l.toString();
            counter++;
        }
        return medalArray;
    }
}