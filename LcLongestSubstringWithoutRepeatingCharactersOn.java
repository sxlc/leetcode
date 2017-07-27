import java.util.HashMap;
import java.util.Map;

public class LcLongestSubstringWithoutRepeatingCharactersOn {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    
    public static int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)), start);
            }
            answer = Math.max(answer, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return answer;
    }
}
