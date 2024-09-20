/*

Q: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

 */

import java.util.Stack;
import java.util.regex.Pattern;

class ValidParenthesis {

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("[\\(\\[\\{]"); // for matching with [ ( { 
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean matches = pattern.matcher(String.valueOf(ch)).matches();
            if (matches) {
                stk.push(ch);
            } else {
                if (stk.empty() || !isValid(stk.peek(), ch)) {
                    return false;
                } else {
                    stk.pop();
                }
            }
        }
        return stk.empty();
    }

    public static boolean isValid(Character ch1, Character ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '[' && ch2 == ']') ||
                (ch1 == '{' && ch2 == '}');
    }

    public static void main(String[] args) {
        String str =  "()[]{}";
        if(isValid(str)) {
            System.out.println(str + " is valid !");
        } else {
            System.out.println(str + " is not valid !");
        }
    }
}

// https://leetcode.com/problems/valid-parentheses/description/