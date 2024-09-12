/*

You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 
*/


// Brute Force -> O(n * M * L)
// class Solution {
//     public int countConsistentStrings(String allowed, String[] words) {
//         if (words.length == 0 || allowed.equals("") || allowed == null) {
//             return 0;
//         } 

//         int count = 0;
//         // O(n) -> n is length of words array
//         for (String word : words) {
//             boolean isMatching = true;
//             // O(M) -> M is length of each word in array
//             for (char ch : word.toCharArray()) {
//                 if (!allowed.contains(String.valueOf(ch))) {  // O(L) -> L is length of word
//                     isMatching = false;
//                     break;
//                 }    // can be optimized by using boolean array for checking
//             }
//             if (isMatching) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// Total Time complexity -> n * M * L            contains() runs M times for each word

// Approch 2 : Using array of boolean to store characters of allowed string and then using that array to check if each character of word is from allowedChar array, instead of using contains each time for each character

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        if (words.length == 0 || allowed.equals("") || allowed == null) {
            return 0;
        }

        // Creating array
        boolean[] allowedChars = new boolean[26];
        for (char ch : allowed.toCharArray()) {     // O(m)     (negligible)
            allowedChars[ch - 'a'] = true;
        }

        int count = 0;                  
        for (String word : words) {                 // O(n)
            if(check(word, allowedChars)) {
                count++;
            }
        }
        return count;
    }

    public boolean check(String word, boolean[] allowedChars) {
        for (char ch : word.toCharArray()) {       // O(L)
            if (!allowedChars[ch - 'a']) {
                return false;
            }
        }
        return true;
    }
}

/*
 *  Total Complexity for 2nd approach:
 *  O(m) + (O(n) * O(L)) = O(n) * O(L) = O(n * L)               O(m) is negligible
 */


// Reference:  https://leetcode.com/problems/count-the-number-of-consistent-strings/description/