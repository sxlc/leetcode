import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Lc00366FindLeavesOfBinaryTreeOn {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(findLeaves(root));
    }
    
    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        findLeavesHelper(leaves, root);
        return leaves;
    }
    
    private static int findLeavesHelper(List<List<Integer>> leaves, TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftLevel = findLeavesHelper(leaves, root.left);
        int rightLevel = findLeavesHelper(leaves, root.right);
        int level = Math.max(leftLevel, rightLevel) + 1;
        if (leaves.size() == level) {
            leaves.add(new ArrayList<>());
        }
        leaves.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
