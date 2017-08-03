/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Lc00333LargestBstSubtreeOn {
    public static void main (String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);
        System.out.println(largestBSTSubtree(root));
    }
    
    public static int largestBSTSubtree(TreeNode root) {
        return helper(root).size;
    }
    
    public static Subtree helper(TreeNode node) {
        Subtree currentSubtree = new Subtree();
        
        if (node == null) {
            currentSubtree.isBst = true;
            return currentSubtree;
        }
        
        Subtree left = helper(node.left);
        Subtree right = helper(node.right);
        
        currentSubtree.lower = Math.min(node.val, left.lower);
        currentSubtree.upper = Math.max(node.val, right.upper);
        
        if (left.isBst && right.isBst && left.upper <= node.val && right.lower >= node.val) {
            currentSubtree.size = left.size + right.size + 1;
            currentSubtree.isBst = true;
        } else {
            currentSubtree.size = Math.max(left.size, right.size);
            currentSubtree.isBst = false;
        }
        
        return currentSubtree;
    }

    public static class Subtree {
        private int size;
        private int lower;
        private int upper;
        private boolean isBst;

        public Subtree() {
            this.lower = Integer.MAX_VALUE;
            this.upper = Integer.MIN_VALUE;
            this.isBst = false;
            this.size = 0;
        }
    }

    public static class TreeNode {  
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int x) {
            this.val = x;
        }
    } 
}
