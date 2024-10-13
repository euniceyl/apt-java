import java.util.*;

public class PathSum {
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

    public int hasPath(int target, TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null && tree.info == target) {
            return 1;
        }
        else if (tree.left == null && tree.right == null && tree.info != target) {
            return 0;
        }
        
        int newTarget = target - tree.info;
        return hasPath(newTarget, tree.left) + hasPath(newTarget, tree.right);
    }
}
