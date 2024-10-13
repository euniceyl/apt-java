import java.util.*;

public class Ograph {
    TreeMap<String, Set<String>> myGraph = new TreeMap<>();
    TreeSet<String> visited = new TreeSet<>();

    public int[] components(String[] data) {
        makeGraph(data);
        ArrayList<Integer> finalList = new ArrayList<>();

        for (String prev : myGraph.keySet()) {
            if (!visited.contains(prev)) {
                finalList.add(dfs(prev));
            }
        }

        int[] og = new int[finalList.size()];
        for (int i = 0; i < finalList.size(); i++) {
            og[i] = finalList.get(i);
        }

        Arrays.sort(og);
        return og;
    }

    public void makeGraph(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String a = data[i];
            String prev = "" + i;
            String[] neighbor = a.split(" ");

            for (String n : neighbor) {
                if (!myGraph.containsKey(prev)) {
                    myGraph.put(prev, new TreeSet<String>());
                }
                if (!myGraph.containsKey(n)) {
                    myGraph.put(n, new TreeSet<String>());
                }
                myGraph.get(prev).add(n);
                myGraph.get(n).add(prev);
            }
        }
    }

    public int dfs(String prev) {
        Stack<String> a = new Stack<>();
        Set<String> indivVisit = new TreeSet<>();
        
        indivVisit.add(prev);
        a.add(prev);

        while (a.size() > 0) {
            prev = a.pop();
            for (String n : myGraph.get(prev)) {
                if (!indivVisit.contains(n)) {
                    a.push(n);
                    indivVisit.add(n);
                }
            }
        }

        visited.addAll(indivVisit);
        return indivVisit.size();
    }
}