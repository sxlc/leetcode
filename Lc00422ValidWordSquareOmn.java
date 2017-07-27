import java.util.Arrays;
import java.util.List;

public class Lc00422ValidWordSquareOmn {
    public static void main(String[] args) {
      System.out.println(validWordSquare(Arrays.asList("abcd", "bnrt", "crmy", "dtye")));
      System.out.println(validWordSquare(Arrays.asList("abcd", "bnrt", "crm", "dt")));
      System.out.println(validWordSquare(Arrays.asList("ball", "area", "read", "lady")));
                        
    }
  
    public static boolean validWordSquare(List<String> words) {
        for (int row = 0; row < words.size(); row++) {
            StringBuilder builder = new StringBuilder();
            for (int column = 0; column < words.size(); column++) {
                if (words.get(column).length() > row) {
                    builder.append(words.get(column).charAt(row));
                }
            }
            if (!builder.toString().equals(words.get(row))) {
                return false;
            }
        }
        return true;
    }
}
