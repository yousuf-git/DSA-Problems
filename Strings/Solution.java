class Solution {
    public int romanToInt(String s) {
        // Using an array to store values of Roman Symbols
        int[] literals = new int[26];
        literals['i' - 'a'] = 1;
        literals['v' - 'a'] = 5;
        literals['x' - 'a'] = 10;
        literals['l' - 'a'] = 50;
        literals['c' - 'a'] = 100;
        literals['d' - 'a'] = 500;
        literals['m' - 'a'] = 1000;

        s = s.toLowerCase(); // for my convenience
        int res = 0;
        
        // Iterate from right to left
        
        boolean flag = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);              // Grab Character
            int value = literals[ch - 'a'];     // Grab Value
            
            flag = true;
            if (i+1 < s.length())
                if(value < literals[s.charAt(i+1) - 'a']) // if curret value is less than char on right
                    flag = false;
                    res -= value;
            
            if(flag)
                res += value;
        }
        return res;
    }
}