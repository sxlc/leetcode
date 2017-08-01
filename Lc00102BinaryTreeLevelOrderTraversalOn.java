import java.util.ArrayList;
import java.util.LinkedList;
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
public class Lc00102BinaryTreeLevelOrderTraversalOn {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodeValues = new ArrayList<>();
        List<Integer> levelNodeValues = new ArrayList<>();
        
        if (root == null) {
            return nodeValues;
        }
        
        List<TreeNode> currentLevel = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.remove(0);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
            levelNodeValues.add(node.val);
            if (currentLevel.isEmpty()) {
                currentLevel = nextLevel;
                nextLevel = new LinkedList<>();
                nodeValues.add(levelNodeValues);
                levelNodeValues = new ArrayList<>();
            }
        }
        return nodeValues;
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
