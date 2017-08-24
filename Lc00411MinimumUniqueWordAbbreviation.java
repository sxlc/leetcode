import java.util.PriorityQueue;

public class Lc00411MinimumUniqueWordAbbreviation {

    public static void main(String[] args) {
        System.out.println(minAbbreviation("apple", new String[]{"blade"}));
        System.out.println(minAbbreviation("apple", new String[]{"plain", "amber", "blade"}));
    }

    public static String minAbbreviation(String target, String[] dictionary) {
        if (target.isEmpty() || dictionary.length == 0) {
            return "";
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>(
            (String s1, String s2) -> s1.length() - s2.length());
        getAbbreviations(queue, target, new StringBuilder(), 0, 0);
        while (!queue.isEmpty()) {
            String abbreviation = queue.poll();
            boolean allValid = true;
            for (String word : dictionary) {
                if (isValidAbbreviation(word, abbreviation)) {
                    allValid = false;
                    break;
                }
            }
            if (allValid) {
                return abbreviation;
            }
        }
        return "";
    }
    
    private static void getAbbreviations(
            PriorityQueue<String> queue,
            String target,
            StringBuilder current,
            int position,
            int count) {
        int len = current.length();
        if (position == target.length()) {
            if (count > 0) {
                current.append(count);
            }
            queue.add(current.toString());
        } else {
            getAbbreviations(queue, target, current, position + 1, count + 1);
            if (count > 0) {
                current.append(count);
            }
            current.append(target.charAt(position));
            getAbbreviations(queue, target, current, position + 1, 0);
        }
        current.setLength(len);
    }
    
    private static boolean isValidAbbreviation(String word, String abbreviation) {
        if (word.isEmpty()) {
            return abbreviation.length() == 0;
        }
        int wordPosition = 0;
        int abbreviationPosition = 0;
        while (wordPosition < word.length() && abbreviationPosition < abbreviation.length()) {
            char c = abbreviation.charAt(abbreviationPosition);
            if (Character.isLetter(c)) {
                if (word.charAt(wordPosition) != abbreviation.charAt(abbreviationPosition)) {
                    return false;
                }
                wordPosition++;
                abbreviationPosition++;
            } else if (Character.isDigit(c)) {
                if (c == '0') {
                    return false;
                }
                int origin = abbreviationPosition;
                while (abbreviationPosition < abbreviation.length() 
                           && Character.isDigit(abbreviation.charAt(abbreviationPosition))) {
                    abbreviationPosition++;
                }
                int num = Integer.valueOf(abbreviation.substring(origin, abbreviationPosition));
                while (wordPosition < word.length() && num > 0) {
                    wordPosition++;
                    num--;
                }
                if (num > 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
