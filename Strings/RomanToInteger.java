public class RomanToInteger {
    static class Solution {
        public int romanToInt(String s) {
            // Using an array to store values of Roman Symbols
            int[] literals = new int[26];
            literals['i' - 'a'] = 1; // ch - 97
            literals['v' - 'a'] = 5;
            literals['x' - 'a'] = 10;
            literals['l' - 'a'] = 50;
            literals['c' - 'a'] = 100;
            literals['d' - 'a'] = 500;
            literals['m' - 'a'] = 1000;
            // Instead of this a separate translator function can be used to save space

            s = s.toLowerCase(); // for my convenience
            int res = 0;

            // Iterate from right to left

            boolean flag = true;
            for (int i = s.length() - 1; i >= 0; i--) { // O(n)
                char ch = s.charAt(i); // Grab Character
                int value = literals[ch - 'a']; // Grab Value

                flag = true;
                if (i + 1 < s.length()) {
                    if (value < literals[s.charAt(i + 1) - 'a']) { // if curret value is less than char on right
                        flag = false;
                        res -= value;
                    }
                }

                if (flag) // If not subtracted, then add
                    res += value;
            }
            return res;
        }

        // private int translate(char c) {
        //     switch(c) {
        //         case 'I':
        //             return 1;
        //         case 'V':
        //             return 5;
        //         case 'X':
        //             return 10;
        //         case 'L':
        //             return 50;
        //         case 'C':
        //             return 100;
        //         case 'D':
        //             return 500;
        //         case 'M':
        //             return 1000;
        //         default:
        //             return 0;
        //     }
        // }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }

}


// Reference
// https://leetcode.com/problems/roman-to-integer/
