/*

Q: String contains duplicate parenthesis if there are un-necessary parenthesis
Note: Given string is valid in term of parenthesis, means each has its pair
Examples:

(((a + b)))              true -> outer 2 pairs are additional
((a+b) + (c+d))          false -> there is no unnecessary parathesis

 */

import java.util.Stack;
import java.util.regex.Pattern;

public class DuplicateParenthesis {
    // Time Complexity: O(n)        Traverse each char only once 
    public static boolean isDuplicate(String s) {
        Stack<Character> stk = new Stack<>();

        Pattern opening = Pattern.compile("[\\{\\[\\(]");
        Pattern closing = Pattern.compile("[\\}\\]\\)]");

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isClosing = closing.matcher(String.valueOf(ch)).matches();

            // If ch is closing parenthesis
            if (isClosing) {
                boolean isTopOpening = opening.matcher(String.valueOf(stk.pop())).matches();
                // If on the top of stack we directly found pair
                if (isTopOpening) {
                    return true; // means there was nothing between them, so it was duplicate
                } else {
                    // remove untill opening pair is found; stk.pop() will remove
                    while (!opening.matcher(String.valueOf(stk.pop())).matches());
                }
            }
            // Push if there is white space or any operand 
            else {
                stk.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println();
        String str = "(((a+b)))"; // true -> outer 2 pairs are additional
        String s = "((a/b) + (cd))"; // false -> there is no unnecessary parathesis

        if (isDuplicate(s)) {
            System.out.println(s + " Contains Duplicate");
        } else {
            System.out.println(s + " Doesn't Contain Duplicate");
        }
        
        System.out.println();

        if (isDuplicate(str)) {
            System.out.println(str + " Contains Duplicate");
        } else {
            System.out.println(str + " Doesn't Contain Duplicate");
        }
        
        System.out.println();
    }
}
