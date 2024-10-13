import java.util.*;

public class FriendScore {

    public TreeMap<Integer, List<Character>> myGraph = new TreeMap<>();
    public TreeMap<Integer, HashSet<Integer>> directFriend = new TreeMap<>();
    public TreeMap<Integer, HashSet<Integer>> twoFriend = new TreeMap<>();

    public int highestScore(String[] friends) {
        int highestScore = 0;
        makeGraph(friends);
        directFriends();
        twoFriends();
        
        for (int f : twoFriend.keySet()) {
            HashSet<Integer> finalSet = twoFriend.get(f);
            if (finalSet.size() > highestScore) {
                highestScore = finalSet.size() - 1;
            }
        }

        return highestScore;
    }

    public void makeGraph(String[] friends) {
        for (int i = 0; i < friends.length; i++) {
            char[] friendsChar = friends[i].toCharArray();
            ArrayList<Character> list = new ArrayList<>();

            for (char c : friendsChar) {
                list.add(c);
            }

            myGraph.put(i, list);
            // if (!myGraph.containsKey(i)) {
            //     HashSet<Integer> set = new HashSet<>();
            // }
            // List<Character> list = myGraph.get(i);
            // for (int j = 0; j < friends[i].length(); j++) {
            //     if (friends[i].charAt(j) == 'Y') {
            //         list.add(friends[i].charAt(j));
            //     }
            // }
            // myGraph.put(i, list);
        }
    }

    public void directFriends() {
        for (int i = 0; i < myGraph.size(); i++) {
            if (!directFriend.containsKey(i)) {
                directFriend.put(i, new HashSet<Integer>());
            }
            for (int j = 0; j < myGraph.size(); j++) {
                if (myGraph.get(j).get(i) == 'Y') {
                    HashSet<Integer> friendSet = directFriend.get(i);
                    friendSet.add(j);
                    directFriend.put(i, friendSet);
                }
            }
        }
    }

    public void twoFriends() {
        for (int i = 0; i < directFriend.size(); i++) {
            if (!twoFriend.containsKey(i)) {
                twoFriend.put(i, new HashSet<Integer>());
            }
            for (int f : directFriend.get(i)) {
                twoFriend.get(i).addAll(directFriend.get(i));
                twoFriend.get(i).addAll(directFriend.get(f));
            }
        }
    }
}