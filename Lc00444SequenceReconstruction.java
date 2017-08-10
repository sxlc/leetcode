import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Lc00444SequenceReconstruction {
    public static void main(String[] args) {
        System.out.println(
                sequenceReconstruction(
                        new int[]{1, 2, 3},
                        Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 3))));
        System.out.println(
                sequenceReconstruction(
                        new int[]{1, 2, 3},
                        Arrays.asList(Arrays.asList(1, 2))));
        System.out.println(
                sequenceReconstruction(
                        new int[]{1, 2, 3},
                        Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(2, 3))));
        System.out.println(
                sequenceReconstruction(
                        new int[]{4, 1, 5, 2, 6, 3},
                        Arrays.asList(Arrays.asList(5, 2, 6, 3), Arrays.asList(4, 1, 5, 2))));
    }

    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();
        
        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            indegrees.put(num, 0);
        }
        
        int count = 0;
        for (List<Integer> seq : seqs) {
            count += seq.size();
            if (seq.size() >= 1 && (seq.get(0) <= 0 || seq.get(0) > org.length)) {
                return false;
            }
            for (int i = 1; i < seq.size(); i++) {
                if (seq.get(i) <= 0 || seq.get(i) > org.length) {
                    return false;
                }
                if (map.get(seq.get(i - 1)).add(seq.get(i))) {
                    indegrees.put(seq.get(i), indegrees.get(seq.get(i)) + 1);
                }
            }
        }
        
        if (count < org.length) {
            return false;
        }
        
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int key : indegrees.keySet()) {
            if (indegrees.get(key) == 0) {
                queue.add(key);
            }
        }
        
        int runningCount = 0;
        while (queue.size() == 1) {
            int element = queue.poll();
            for (int next : map.get(element)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
            if (element != org[runningCount]) {
                return false;
            }
            runningCount++;
        }
        
        return runningCount == org.length;
    }
}
