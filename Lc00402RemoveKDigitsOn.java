import java.util.Stack;

public class Lc00402RemoveKDigitsOn {
    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }
  
    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        if (num.length() == 0 || num.length() <= k) {
            return "0";
        }
        
        for (int i = 0; i < num.length(); i++) {
            int current = num.charAt(i) - '0';
            while (!stack.isEmpty() 
                    && current < stack.peek() 
                    && num.length() - i - 1 >= num.length() - k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < num.length() - k) {
                stack.push(current);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
