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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> nodeValues = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> levelNodeValues = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return nodeValues;
        }
        
        List<TreeNode> currentLevel = new LinkedList<>();
        List<TreeNode> nextLevel = new LinkedList<>();
        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.remove();
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
}
