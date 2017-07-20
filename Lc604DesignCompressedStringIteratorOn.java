public class Lc604DesignCompressedStringIteratorOn {

    public static void main(String[] args) {
        String compressedString = "L1e2t1C1o1d1e1";
        Stringiterator iterator = new StringIterator(compressedString);
        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
    
    public class StringIterator {
        private String result;
        private int pointer = 0;
        private int times = 0;
        private char ch = ' ';

        public StringIterator(String compressedString) {
            result = compressedString;
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            if (times == 0) {
                ch = result.charAt(pointer++);
                while (pointer < result.length() && Character.isDigit(result.charAt(pointer))) {
                    times = times * 10 + result.charAt(pointer++) - '0';
                }
            }
            times--;
            return ch;
        }

        public boolean hasNext() {
            return pointer != result.length() || times != 0;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
