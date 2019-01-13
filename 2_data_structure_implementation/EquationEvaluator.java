import java.util.*;

public class EquationEvaluator { 

    static public int evaluate(String equation) {
        Stack<String> stack = new Stack<>();

        for (char c : equation.toCharArray()) {
            if (c == ' ' || c == ')' || c == '(' ) {
                continue;
            } else if (isOperator(Character.toString(c)) || stack.isEmpty() ) {
                stack.push(Character.toString(c));
            } else { // current char is a num and the top of the stack
                if (stack.peek().equals("+")) {
                    stack.pop(); // remove operator from stack
                    stack.push(addStrings(stack.pop(), Character.toString(c)));
                } else if (stack.peek().equals("-")) {
                    stack.pop(); // remove operator from stack
                    stack.push(subtractStrings(stack.pop(), Character.toString(c)));
                } 
            }
        }

        // evaluate remaining stack
        while (stack.size() != 1) {
            String item = stack.pop();
           if (!isOperator(item)) {
                String operator = stack.pop();
                if (operator.equals("+")) {
                    stack.push(addStrings(item, stack.pop()));
                } else {
                    stack.push(subtractStrings(item, stack.pop()));
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private static String addStrings(String num1, String num2) {
        return String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
    }

    private static String subtractStrings(String num1, String num2) {
        return String.valueOf(Integer.valueOf(num1)  - Integer.valueOf(num2));
    }

    private static boolean isOperator(String op) {
        return op.equals("+") || op.equals("-");
    }
    
   public static void main(String[] args) { 
        System.out.println(EquationEvaluator.evaluate("1 + (2 - 3)") == 0 ? "PASS" : "FAIL");
        System.out.println(EquationEvaluator.evaluate("(1 - 2) + 3)") == 2 ? "PASS" : "FAIL");
        System.out.println(EquationEvaluator.evaluate("(1 - 2 + (1 + 3)) + 3)") == 6 ? "PASS" : "FAIL");
        System.out.println(EquationEvaluator.evaluate("(1 - 2 + (1 + 3 - 1)) + 3)") == 5 ? "PASS" : "FAIL");
   }
}