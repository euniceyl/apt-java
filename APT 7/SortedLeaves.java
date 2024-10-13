import java.util.*;

public class SortedLeaves {
    public class TreeNode {
        int info;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            info = x;
        }
        TreeNode (int x, TreeNode lNode, TreeNode rNode) {
            info = x;
            left = lNode;
            right = rNode;
        }
    }

    ArrayList<String> list = new ArrayList<>();

    public String[] values(TreeNode tree) {
        toAlphabet(tree);
        Collections.sort(list);
        String[] finalList = new String[list.size()];
        finalList = list.toArray(finalList);
        return finalList;
    }

    public void toAlphabet(TreeNode tree) {
        if (tree == null) {
            return;
        }

        if (tree.left == null && tree.right == null) {
            char ascii = (char) tree.info;
            String alphabet = Character.toString(ascii);
            list.add(alphabet);
            return;
        }

        toAlphabet(tree.left);
        toAlphabet(tree.right);
    }
}
