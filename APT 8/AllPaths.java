import java.util.*;

public class AllPaths {
    public class TreeNode {
        int info;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            info = x;
        }
        TreeNode(int x, TreeNode lNode, TreeNode rNode) {
            info = x;
            left = lNode;
            right = rNode;
        }
    }

    ArrayList<String> list = new ArrayList<>();

    public void rec(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            path = path + node.info;
            list.add(path);
            return;
        }
        path = path + node.info + "->";
        rec(node.left, path);
        rec(node.right, path);
    }

    public String[] paths(TreeNode t) {
        if (t != null) {
            rec(t, "");
        }
        Collections.sort(list);
        String[] finalList = list.toArray(new String[0]);
        return finalList;
    }
}
