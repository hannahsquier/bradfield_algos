import java.util.*;

public class Pangram { 
    
    // Space: O(1)
    // Time: O(26 * n) -> O(n)
    static boolean nestedLoop(String str) {
        for (char alpha = 'a'; alpha < 'z'; alpha++) {
            boolean containsChar = false;
            for (char letter : str.toCharArray()) {
                if (letter == alpha) {
                    containsChar = true;
                    break;
                }
            }
            if (!containsChar) return false;
        }
        return true;
    }

    // Space: O(n)
    // Time: O(26 * 1) -> O(1)
    static boolean useSet(String str) {
        Set<Character> letters = new HashSet<>();
        for (char letter : str.toCharArray()) letters.add(letter);

        for (char alpha = 'a'; alpha < 'z'; alpha++) {
            if (!letters.contains(alpha)) return false;
        }

        return true;
    }

    // Space: O(1)
    // Time: O(n)
    static boolean filterDistintCount(String str) {
        return str.chars()
                  .filter(letter -> letter >= (int)'a')
                  .filter(letter ->letter <= (int)'z')
                  .distinct().count() == 26;
    }
    
   public static void main(String[] args) { 
        
        final String pangram = "the quick brown fox jumps over the lazy dog";
        final String notPangram = "the quick brown fox jumps over the lazy cat";

        System.out.println(nestedLoop(pangram) == true ? "PASS" : "FAIL");
        System.out.println(nestedLoop(notPangram) == false ? "PASS" : "FAIL");

        System.out.println(useSet(pangram) == true ? "PASS" : "FAIL");
        System.out.println(useSet(notPangram) == false ? "PASS" : "FAIL");

        System.out.println(filterDistintCount(pangram) == true ? "PASS" : "FAIL");
        System.out.println(filterDistintCount(notPangram) == false ? "PASS" : "FAIL");

   }
}