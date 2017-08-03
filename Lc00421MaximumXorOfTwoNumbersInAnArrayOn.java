import java.util.HashSet;
import java.util.Set;

public class Lc00421MaximumXorOfTwoNumbersInAnArrayOn {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int tempMax = max | (1 << i);
            System.out.println("Mask: " + mask + "  TempMax: " + tempMax + "  Max: " + max);
            for (int prefix : prefixes) {
                if (prefixes.contains(tempMax ^ prefix)) {
                    max = tempMax;
                    break;
                }
            }
        }
        return max;
    }
}
