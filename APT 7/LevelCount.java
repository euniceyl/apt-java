import java.util.*;

public class LevelCount {
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

    public int count(TreeNode t, int level) {
        if (t == null) {
            return 0;
        }
        if (level == 0) {
            return 1;
        }

        int newLevel = level - 1;
        return count(t.left, newLevel) + count(t.right, newLevel);
    }
}