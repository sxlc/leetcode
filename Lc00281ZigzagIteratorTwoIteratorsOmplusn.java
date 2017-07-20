import java.lang.Integer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lc00281ZigzagIteratorTwoIteratorsOmplusn {

    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        List<Integer> v2 = new ArrayList<>();
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigzagIterator iterator = new ZigzagIterator(v1, v2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
    public static class ZigzagIterator {
        private Iterator<Integer> iterator1;
        private Iterator<Integer> iterator2;
        private int index;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            iterator1 = v1.iterator();
            iterator2 = v2.iterator();
            index = 0;
        }

        public int next() {
            if (!hasNext()) {
                return 0;
            }
            int result = 0;
            if (index % 2 == 0 && iterator1.hasNext() || !iterator2.hasNext()) {
                result = iterator1.next();
            } else if (index % 2 == 1 && iterator2.hasNext() || !iterator1.hasNext()) {
                result = iterator2.next();
            }
            index++;
            return result;
        }

        public boolean hasNext() {
            return iterator1.hasNext() || iterator2.hasNext();
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
