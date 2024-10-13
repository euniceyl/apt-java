import java.util.*;

public class LeafTrails {
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

    TreeMap<Integer, String> map = new TreeMap<>();

    public void mapping(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            map.put(node.info, path);
            return;
        }
        mapping(node.left, path + "0");
        mapping(node.right, path + "1");
    }

    public String[] trails(TreeNode tree) {
        mapping(tree, "");
        String[] ret = new String[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            ret[index] = map.get(key);
            index = index + 1;
        }
        return ret;
    }
}
