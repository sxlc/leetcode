import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lc00078SubsetsBitManipulationOn2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }
    
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < (1 << length); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) > 0) {
                    temp.add(nums[j]);
                }
            }
            results.add(temp);
        }
        return results;
    }
}
