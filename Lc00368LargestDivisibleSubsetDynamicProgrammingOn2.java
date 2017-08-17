import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc00368LargestDivisibleSubsetDynamicProgrammingOn2 {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
  
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        
        int len = nums.length;
        int[] parents = new int[len];
        int[] counts = new int[len];
        int max = 0;
        int maxIndex = -1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (nums[j] % nums[i] == 0 && counts[i] < counts[j] + 1) {
                    counts[i] = counts[j] + 1;
                    parents[i] = j;
                    if (counts[i] > max) {
                        max = counts[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < max; i++) {
            result.add(nums[maxIndex]);
            maxIndex = parents[maxIndex];
        }
        return result;
    }
}
