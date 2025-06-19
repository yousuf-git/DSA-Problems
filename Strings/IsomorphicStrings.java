import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
// import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class IsomorphicStrings {
    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        boolean result = isIsomorphic(s1, s2);
        System.out.println("Are the strings isomorphic? " + result);
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] arr = new int[256];

        for (int i = 0; i < arr.length; i++) arr[i] = -1;

        // For s
        for (int i = 0; i < s.length(); i++) {
            int asciiOfChar1 = s.charAt(i);
            int asciiOfChar2 = t.charAt(i);

            if (arr[asciiOfChar1] != -1) {
                if (arr[asciiOfChar1] != asciiOfChar2) return false;
            } else arr[asciiOfChar1] = asciiOfChar2;
        }

        for (int i = 0; i < arr.length; i++) arr[i] = -1;
        
        // For t
        for (int i = 0; i < s.length(); i++) {
            int asciiOfChar1 = s.charAt(i);
            int asciiOfChar2 = t.charAt(i);

            if (arr[asciiOfChar2] != -1) {
                if (arr[asciiOfChar2] != asciiOfChar1) return false;
            } else arr[asciiOfChar2] = asciiOfChar1;
        }

        return true;

    }

    // ----------- Brute Force Using HashMap => O(n^2) -----------

    public static boolean bruteForce(String s, String t) {
        // First index of list will have the count, next will be indices of resp. char
        Map<Character, List<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map1.containsKey(Character.valueOf(ch))) {
                List<Integer> list = map1.get(ch); // get list
                list.add(i); // add index
                list.set(0, list.get(0) + 1); // update count
            } else
                map1.put(ch, new ArrayList<>(Arrays.asList(1, i)));
        }

        Map<Character, List<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map2.containsKey(Character.valueOf(ch))) {
                List<Integer> list = map2.get(ch); // get list
                list.add(i); // add index
                list.set(0, list.get(0) + 1); // update count
            } else
                map2.put(ch, new ArrayList<>(Arrays.asList(1, i)));
        }
        removeSingleCountKeys(map1);
        removeSingleCountKeys(map2);

        if (map1.size() != map2.size())
            return false;

        for (List<Integer> list : map1.values()) {
            if (!map2.containsValue(list))
                return false;
        }
        return true;

    }

    public static void removeSingleCountKeys(Map<Character, List<Integer>> map) {
        Set<Character> keysToRemove = new HashSet<>();

        // First identify keys to remove
        for (Character key : map.keySet()) {
            if (map.get(key).get(0) == 1) {
                keysToRemove.add(key);
            }
        }

        // Then remove them
        for (Character key : keysToRemove) {
            map.remove(key);
        }
    }

    //// Didn't work
    // public boolean isIsomorphic(String s, String t) {return countUniq(s) == countUniq(t);}

    // ============ Helper ============
    // public int countUniq(String s) {
    //     Set<Character> set = new HashSet<>();
    //     for (int i = 0; i < s.length(); i++) set.add(s.charAt(i));
    //     return set.size();
    // }
}