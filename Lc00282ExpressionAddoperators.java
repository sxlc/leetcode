import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static List<String> result;
  
    public static void main(String[] args) {
        System.out.println(addOperators("1432219", 3));
        System.out.println(addOperators("10200", 1));
        System.out.println(addOperators("10", 2));
    }
  
    public static List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, "", 0, 0);
        return result;
    }
    
    private static void helper(
            String num, int target, String temp, long currentResult, long previousNumber) {
        if (currentResult == target && num.isEmpty()) {
            String expression = new String(temp);
            result.add(expression);
            return;
        }
        
        for (int i = 1; i <= num.length(); i++) {
            String currentString = num.substring(0, i);
            if (currentString.length() > 1 && currentString.charAt(0) == '0') {
                return;
            }
            long currentNumber = Long.parseLong(currentString);
            String next = num.substring(i);
            if (!temp.isEmpty()) {
                helper(next, 
                       target, 
                       temp + "*" + currentNumber, 
                       (currentResult - previousNumber) + previousNumber * currentNumber,
                       previousNumber * currentNumber);
                helper(next,
                       target,
                       temp + "+" + currentNumber,
                       currentResult + currentNumber, 
                       currentNumber);
                helper(next,
                       target, 
                       temp + "-" + currentNumber,
                       currentResult - currentNumber,
                       -currentNumber);
            } else {
                helper(next, target, currentString, currentNumber, currentNumber);
            }
        }
    }
}
