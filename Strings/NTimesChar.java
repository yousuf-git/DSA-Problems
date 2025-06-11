class NTimesChar {

    public static void main(String[] args) {
        String[] inputs = {"3[a]2[bc]", "3[a2[c]]", "2[ab3[ca]2[b]]", "2[2[a3[b4[c]]]]" };
        // expected output: aaabcbc, accaccacc
        // System.out.println(inputs);
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Result for " + inputs[i] + " is: " + recurse(inputs[i]));
            idx = 0;        // reset the universal idx for next recursive call
        }
        // System.out.println(recurse(inputs[3]));

        
    }

    static int idx = 0;

    static String recurse(String str) {
        
        if (idx >= str.length()) return "";

        char ch = str.charAt(idx);
        idx++;

        if (ch == ']') return "";
        
        
        if (Character.isDigit(ch)) {
            
            StringBuilder res = new StringBuilder();
            
            idx++;       // skip ->    [
            
            String innerRes = recurse(str);          // recursive call
            int limit = Integer.valueOf(String.valueOf(ch));
            
            for (int i = 0; i < limit; i++) {
                res.append(innerRes);
            }
            
            if (idx < str.length()) {
                return res.append(recurse(str)).toString();
            } else {
                return res.toString();
            }
        }
        
        // If ch is any alphabet, choose ch and append result of next evaluation with it
        return new StringBuilder(String.valueOf(ch)).append(recurse(str)).toString(); // char + recurse()


    }
}