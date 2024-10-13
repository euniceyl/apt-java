import java.util.*;

public class HeightLabel {
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

    public TreeNode rewire(TreeNode t) {
        if (t == null) {
            return null;
        }
        return new TreeNode(level(t), rewire(t.left), rewire(t.right));
    }

    public int level(TreeNode t) {
        if (t == null) {
            return 0;
        }
        return Math.max(level(t.left) + 1, level(t.right) + 1);
    }
}