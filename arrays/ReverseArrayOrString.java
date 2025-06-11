public class ReverseArrayOrString {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 9, -1 };
        System.out.print("Original Array: ");
        Array.printArray(array);

        reverseArray(array);
        
        System.out.print("Reversed Array: ");
        Array.printArray(array);

        String str = "Hello";
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverseString(str));

    }

    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            char temp = charArray[start];
            charArray[start++] = charArray[end];
            charArray[end--] = temp;
        }
        return new String(charArray);
    }
    
    // Built-in method
    // public static String reveString(String str) {
    //     return new StringBuilder(str).reverse().toString();
    // }


    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
            // start++;
            // end--;
        }
    }

}
