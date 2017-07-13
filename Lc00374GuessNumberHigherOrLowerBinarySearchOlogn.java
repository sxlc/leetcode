public class Lc00374GuessNumberHigherOrLowerBinarySearchOlogn {

    public static void main(String[] args) {
    
    }
    
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int result = guess(middle);
            if (result == -1) {
                high = middle - 1;
            } else if (result == 1) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
