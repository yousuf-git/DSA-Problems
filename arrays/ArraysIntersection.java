import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ArraysIntersection {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {2, 2};
        int[] result = intersection(arr1, arr2);
        
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // =========== O(n+m) by using set --> additional memory ===========
    private static int[] intersection(int[] n1, int[] n2) {
        int size = 0;
        if (n1.length < n2.length) size = n1.length;
        else size = n2.length;
        int[] res = new int[size];

        Set<Integer> s1 = new HashSet<>();
        for (int e : n1) {
            s1.add(e);
        }
        
        Set<Integer> s2 = new HashSet<>();
        for (int e : n2) {
            s2.add(e);
        }
        
        Iterator<Integer> i = s1.iterator();
        int ptr = 0;
        while (i.hasNext()) {
            Integer e = i.next();
            if (s2.contains(e)) res[ptr++] = e;
        }
        
        return res;
    }

    // =========== O(n+m) but without set, using boolean array ===========
    // ======== Perfromed faster because array operations are fast
    public static int[] optimizedIntersaction(int[] n1, int[] n2) {
        
        int size = 0;
        if (n1.length > n2.length) size = n1.length;
        else size = n2.length;
        int[] res = new int[size];

        boolean[] bucket = new boolean[1001];   // 0 <= nums1[i], nums2[i] <= 1000

        for (int e : n1) {
            bucket[e] = true;
        }

        // Now bucket[i] will be true if i is present in n1
        // So, we can check if n2[i] is present in n1 by checking
        // bucket[n2[i]] and if it is true, we can add it to result
        // and set bucket[n2[i]] to false so that we don't add it again
        // This way we can avoid duplicates in result
        // Also, we can use a pointer to keep track of the position in result array
        // and return the result array with the correct size

        int ptr = 0;
        for (int e : n2) {
            if (true == bucket[e]) {
                res[ptr++] = e;
                bucket[e] = false;
            }
        }
        return Arrays.copyOf(res, ptr);
    }


}
