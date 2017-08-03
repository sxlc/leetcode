import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lc00315CountOfSmallerNumbersAfterHalfOn2 {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
  
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        result.add(0);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = addNode(root, nums[i]);
            result.add(count);
        }
        
        Collections.reverse(result);
        return result;
    }
    
    private static int addNode(TreeNode root, int val) {
        int currentCount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                currentCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        
        return currentCount;
    }

    public static class TreeNode {
        private int val;
        private int count = 1;
        private TreeNode left;
        private TreeNode right;
        
        public TreeNode(int val) {
         this.val = val;
        }
    }
}
