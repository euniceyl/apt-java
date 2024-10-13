import java.util.*;

public class ErdosNumber {
    TreeMap<String, Set<String>> myGraph = new TreeMap<>();
    TreeMap<String, Integer> myDistance = new TreeMap<>();

    public String[] calculateNumbers(String[] pubs) {
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos();
        for (String s : myGraph.keySet()) {
            if (myDistance.containsKey(s)) {
                s = s + " " + myDistance.get(s);
            }
            list.add(s);
        }
        return list.toArray(new String[0]);
    }

    public void makeGraph(String[] pubs) {
        myGraph = new TreeMap<>();
        for (String authors : pubs) {
            String[] authorAr = authors.split(" ");
            for (int i = 0; i < authorAr.length; i++) {
                TreeSet<String> adj = new TreeSet<>(Arrays.asList(authorAr));
                if (!myGraph.containsKey(authorAr[i])) {
                    myGraph.put(authorAr[i], new TreeSet<String>());
                }
                adj.remove(authorAr[i]);
                myGraph.get(authorAr[i]).addAll(adj);
            }
            // for (String a : authorAr) {
            //     if (!myGraph.containsKey(a)) {
            //         myGraph.put(a, new HashSet<>());
            //     }
            //     for (String b : authorAr) {
            //         if (!a.equals(b)) {
            //             myGraph.get(a).add(b);
            //         }
            //     }
            //}
        }
    }

    public void bfsErdos() {
        Set<String> visited = new TreeSet<>();
        Queue<String> qu = new LinkedList<>();

        myDistance.put("ERDOS", 0);
        visited.add("ERDOS");
        qu.add("ERDOS");
        
        while (qu.size() > 0) {
            String authorAr = qu.remove();
            for (String adj : myGraph.get(authorAr)) {
                if (!visited.contains(adj)) {
                    myDistance.put(adj, myDistance.get(authorAr)+1);
                    visited.add(adj);
                    qu.add(adj);
                }
            }
        }
    }
}