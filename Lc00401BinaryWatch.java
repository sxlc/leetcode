import java.util.ArrayList;
import java.util.List;

public class Lc00401BinaryWatch {
  
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(0));
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(2));
        System.out.println(readBinaryWatch(3));
        System.out.println(readBinaryWatch(4));
        System.out.println(readBinaryWatch(5));
        System.out.println(readBinaryWatch(6));
        System.out.println(readBinaryWatch(7));
        System.out.println(readBinaryWatch(8));
    }
        
    public static List<String> readBinaryWatch(int num) {
        int hourCount = 4;
        int minuteCount = 6;
        List<String> res = new ArrayList<>();

        for (int i = num > minuteCount? (num - minuteCount) : 0; i <= Math.min(hourCount, num); i++) {
            List<Integer> hours = getCombination(hourCount, i);
            List<Integer> minutes = getCombination(minuteCount, num - i);
            for (Integer hour : hours) {
                if (hour >= 12) {
                    continue;
                }
                for (Integer minute : minutes) {
                    if (minute <= 59) {
                        res.add(String.format("%d:%02d", hour, minute));
                    }
                }
            }
        }
        return res;
    }
  
    private static List<Integer> getCombination(int ledCnt, int num) {
        if(num <= 0) {
            List<Integer> combinations = new ArrayList<>();
            combinations.add(0);
            return combinations;
        }
        if (ledCnt == num) {
            List<Integer> combinations = new ArrayList<Integer>();
            int data = 0;
            for (int i = 0; i < num; i++) {
                data += 1 << i;
            }
            combinations.add(data);
            return combinations;
        } else {
            List<Integer> combinations = new ArrayList<Integer>();
            if (num > 1) {
                List<Integer> subList = getCombination(ledCnt - 1, num - 1);
                Integer []a = new Integer[subList.size()];
                subList.toArray(a);
                int high = 1 << (ledCnt - 1);
                for (int i = 0; i < a.length; i++) {
                    combinations.add(a[i] + high);
                }
            } else {
                combinations.add(1 << (ledCnt - 1));
            }
            combinations.addAll(getCombination(ledCnt - 1, num));
            return combinations;
        }
    }
}
