import java.util.*;

public class StackReverse { 
    
    // Time: O(2 * n) -> O(n)
    // Space: O(2 * n) -> O(n)
    public static <T> List<T> reverse(List<T> list) {
        Stack<T> stack = new Stack<>();
        for (T elem : list) stack.push(elem);
        List<T> reversedList = new ArrayList<>();
        while (!stack.isEmpty()) reversedList.add(stack.pop());
        return reversedList;
    }
    
   public static void main(String[] args) { 
        
        final List<Integer> intList = Arrays.asList(1, 2, 3);
        final List<Integer> reversedIntList = reverse(intList);
        System.out.println(reversedIntList.equals(Arrays.asList(3, 2, 1)) ? "PASS" : "FAIL");

        final List<Character> charList = Arrays.asList('a', 'b', 'c');
        final List<Character> reversedCharList = reverse(charList);
        System.out.println(reversedCharList.equals(Arrays.asList('c', 'b', 'a')) ? "PASS" : "FAIL");

   }
}