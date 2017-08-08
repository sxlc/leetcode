import java.util.LinkedList;
import java.util.Queue;

public class Lc00210CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(numCourses, prerequisites);
        for (int item : order) {
            System.out.println(item);
        }
    }
  
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            return new int[]{};
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int number = queue.poll();
            order[index++] = number;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == number) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }
        return index == numCourses ? order : new int[]{};
    }
}
